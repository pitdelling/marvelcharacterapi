package br.com.philip.marvelcharacterapi.shared.util;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 * class MarvelCharacterApiUtil
 *
 * @author philip.delling
 */
public class MarvelCharacterApiUtil {

    public static String encryptToMD5(final String textToEncrypt) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(textToEncrypt.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (Exception e) {
            System.err.println("There was an error inside MarvelCharacterApiUtil.encryptToMD5.");
            throw e;
        }
    }
}
