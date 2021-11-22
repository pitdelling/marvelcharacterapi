package br.com.philip.marvelcharacterapi.service.marvelapi;

import java.util.List;
import br.com.philip.marvelcharacterapi.model.character.Character;

/**
 * interface MarvelApiController
 *
 * @author philip.delling
 */
public interface MarvelApiService {

    public List<Number> getCharacterIds() throws Exception;

    public Character getCharacter(final Number id, final String languageCode) throws Exception;
}
