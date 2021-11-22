package br.com.philip.marvelcharacterapi.shared.standard.servicerestresponse;

import lombok.Getter;
import lombok.Setter;

/**
 * class ServiceRestResponseStandard
 *
 * @author philip.delling
 */
@Getter
@Setter
public class ServiceRestResponseStandard<T> {

    private float code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private T data;
}
