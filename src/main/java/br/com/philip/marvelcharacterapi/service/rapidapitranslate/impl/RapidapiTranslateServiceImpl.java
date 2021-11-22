package br.com.philip.marvelcharacterapi.service.rapidapitranslate.impl;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import br.com.philip.marvelcharacterapi.service.rapidapitranslate.RapidapiTranslateService;

/**
 * class RapidapiTranslateServiceImpl
 *
 * @author philip.delling
 */
@Service
@Component("rapidapiTranslateService")
public class RapidapiTranslateServiceImpl implements RapidapiTranslateService {

    @Override
    public String translateText(final String textToTranslate, final String languageCodeOrigin, final String languageCodeTarget)
            throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("https://deep-translate1.p.rapidapi.com/language/translate/v2")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-rapidapi-host", "deep-translate1.p.rapidapi.com")
                .header("x-rapidapi-key", "96a0406807msh3668bed94d5d1b5p1018c4jsn2854f6537783")
                .body(getBody(textToTranslate, languageCodeOrigin, languageCodeTarget)).asJson();
         
        if (response.getStatus() == 200) {
            JSONObject data = response.getBody().getObject().getJSONObject("data").getJSONObject("translations");
            return data.getString("translatedText");
        }
              
        return textToTranslate;
    }

    private String getBody(final String textToTranslate, final String languageCodeOrigin, final String languageCodeTarget) {
        return new StringBuilder("{\"q\":\"").append(textToTranslate).append("\",\"source\":\"").append(languageCodeOrigin).append("\",\"target\":\"")
                .append(languageCodeTarget).append("\"}").toString();
    }

}
