package br.com.philip.marvelcharacterapi.service.marvelapi.impl.response;

import java.util.List;
import br.com.philip.marvelcharacterapi.model.character.Character;
import br.com.philip.marvelcharacterapi.shared.standard.servicerestresponse.ServiceRestResponseBodyStandard;
import lombok.Getter;
import lombok.Setter;

/**
 * class MarvelApiServiceCharacterBodyResponse
 *
 * @author philip.delling
 */
@Getter
@Setter
public class MarvelApiServiceCharacterBodyResponse extends ServiceRestResponseBodyStandard<List<Character>> {
}
