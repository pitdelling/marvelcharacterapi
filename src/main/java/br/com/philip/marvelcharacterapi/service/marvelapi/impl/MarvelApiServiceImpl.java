package br.com.philip.marvelcharacterapi.service.marvelapi.impl;

import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.philip.marvelcharacterapi.model.character.Character;
import br.com.philip.marvelcharacterapi.service.marvelapi.MarvelApiService;
import br.com.philip.marvelcharacterapi.service.marvelapi.impl.response.MarvelApiServiceCharacterBodyResponse;
import br.com.philip.marvelcharacterapi.service.marvelapi.impl.response.MarvelApiServiceCharacterResponse;
import br.com.philip.marvelcharacterapi.service.rapidapitranslate.RapidapiTranslateService;
import br.com.philip.marvelcharacterapi.shared.util.MarvelCharacterApiUtil;

/**
 * class MarvelApiServiceImpl
 *
 * @author philip.delling
 */
@Service
@Component("marvelApiService")
public class MarvelApiServiceImpl implements MarvelApiService {

    private static final String PUBLIC_KEY = "9955efd1e974105f841dc042070dbd30";
    private static final String PRIVATE_KEY = "d75997dab1d5acc5b5b7adeecc6cac63f24b4948";
    private static final String URL_BASE = "http://gateway.marvel.com/v1/public/characters";
    private static final String URL_ID_PARAM = "/{id}";
    private static final String URL_PARAMS = "?orderBy=name&limit=100&offset={offset}&ts={ts}&apikey={apikey}&hash={hash}";
    private static final String URL_COMPLETE = new StringBuilder(URL_BASE).append(URL_PARAMS).toString();
    private static final String URL_COMPLETE_WITH_ID = new StringBuilder(URL_BASE).append(URL_ID_PARAM).append(URL_PARAMS).toString();

    private static List<Character> characters = new ArrayList<>();

    @Resource(name = "rapidapiTranslateService")
    private RapidapiTranslateService rapidapiTranslateService;

    @Cacheable(value = "getCharacterIds")
    public List<Number> getCharacterIds() throws Exception {
        if (characters.isEmpty()) {
            executeMarvelApiGetAllCharactersRequest();
        }
        return characters.stream().map(character -> character.getId()).collect(Collectors.toList());
    }

    @Cacheable(value = "getCharacter")
    public Character getCharacter(final Number characterId, final String languageCode) {
        try {
            MarvelApiServiceCharacterResponse response = new RestTemplate().getForObject(URL_COMPLETE_WITH_ID,
                    MarvelApiServiceCharacterResponse.class, getMarvelApiRequestParams(0, characterId));
            MarvelApiServiceCharacterBodyResponse responseBody = response.getData();
            List<Character> characters = responseBody.getResults();
            if (characters == null || characters.isEmpty()) {
                return null;
            } else {
                Character character = characters.get(0);
                if (!languageCode.isEmpty() && !languageCode.equalsIgnoreCase("en")) {
                    String translatedDescription = rapidapiTranslateService.translateText(character.getDescription(), "en",
                            languageCode.toLowerCase());
                    character.setDescription(translatedDescription);
                }
                return character;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception {
        //        String a = rapidapiTranslateService.translateText("O philip é muito top", "pt", "en");
        //        System.out.println(a);

        executeMarvelApiGetAllCharactersRequest();
    }

    private void executeMarvelApiGetAllCharactersRequest() throws Exception {
        boolean isAlreadyGetAllCharacters = false;
        float offset = 0;
        while (!isAlreadyGetAllCharacters) {
            MarvelApiServiceCharacterResponse response = new RestTemplate().getForObject(URL_COMPLETE,
                    MarvelApiServiceCharacterResponse.class, getMarvelApiRequestParams(offset, null));
            MarvelApiServiceCharacterBodyResponse responseBody = response.getData();
            characters.addAll(responseBody.getResults());
            int size = characters.size();
            if (size == responseBody.getTotal()) {
                isAlreadyGetAllCharacters = true;
            } else {
                offset = size;
            }
        }
    }

    private Map<String, Object> getMarvelApiRequestParams(final float offset, final Number characterId) throws Exception {
        Long ts = new Date().getTime();
        Map<String, Object> params = new HashMap<>();
        params.put("ts", ts);
        params.put("offset", offset);
        params.put("apikey", PUBLIC_KEY);
        params.put("hash", getMarvelApiRequestHashParam(ts));
        if (characterId != null) {
            params.put("id", characterId);
        }
        return params;
    }

    private String getMarvelApiRequestHashParam(final Long ts) throws Exception {
        String textToEncrypt = new StringBuilder(ts.toString()).append(PRIVATE_KEY).append(PUBLIC_KEY).toString();
        return MarvelCharacterApiUtil.encryptToMD5(textToEncrypt).toLowerCase();
    }

}
