package br.com.philip.marvelcharacterapi.model.character;

import br.com.philip.marvelcharacterapi.shared.standard.general.MarvelCharacterApiStandardClass;
import lombok.Getter;
import lombok.Setter;

/**
 * class Character
 *
 * @author philip.delling
 */
@Getter
@Setter
public class Character extends MarvelCharacterApiStandardClass {

    private Number id;
    private String name;
    private String description;
    private CharacterThumbnail thumbnail;
}
