package br.com.philip.marvelcharacterapi.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.philip.marvelcharacterapi.model.character.Character;
import br.com.philip.marvelcharacterapi.service.marvelapi.MarvelApiService;
import io.swagger.annotations.*;

/**
 * class CharacterController
 *
 * @author philip.delling
 */
@Api(tags = "Character")
@PropertySource("classpath:br/com/philip/marvelcharacterapi/controller/characterController-msg.properties")
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Resource(name = "marvelApiService")
    private MarvelApiService marvelApiService;

    @ApiOperation(value = "${getCharacterIds.title}", notes = "${getCharacterIds.description}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "ok") })
    @GetMapping("")
    public List<Number> getCharacterIds() throws Exception {
        return marvelApiService.getCharacterIds();
    }

    @ApiOperation(value = "${getCharacter.title}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "ok") })
    @GetMapping("/{characterId}")
    public ResponseEntity<Character> getCharacter(
            @ApiParam(name = "characterId", value = "${getCharacter.param.characterId}",
                    example = "1011793") @PathVariable("characterId") final Number characterId,
            @ApiParam(name = "languageCode", value = "${getCharacter.param.languageCode}",
                    example = "pt") @RequestParam(name = "languageCode", defaultValue = "en") final String languageCode)
            throws Exception {
        Character character = marvelApiService.getCharacter(characterId, languageCode);
        if (character == null) {
            return new ResponseEntity<Character>(new Character(), HttpStatus.OK);
        }
        return new ResponseEntity<Character>(character, HttpStatus.OK);
    }

}
