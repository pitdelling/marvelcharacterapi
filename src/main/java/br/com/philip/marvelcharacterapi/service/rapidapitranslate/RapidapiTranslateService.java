package br.com.philip.marvelcharacterapi.service.rapidapitranslate;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * class RapidapiTranslateService
 *
 * @author philip.delling
 */
public interface RapidapiTranslateService {

    public String translateText(final String textToTranslate, final String languageCodeOrigin, final String languageCodeTarget)
            throws UnirestException;
}
