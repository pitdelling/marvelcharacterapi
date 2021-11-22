package br.com.philip.marvelcharacterapi.shared.standard.servicerestresponse;

import lombok.Getter;
import lombok.Setter;

/**
 * class ServiceRestResponseBodyStandard
 *
 * @author philip.delling
 */
@Getter
@Setter
public class ServiceRestResponseBodyStandard<T> {

    private float offset;
    private float limit;
    private float total;
    private float count;
    private T results;
}
