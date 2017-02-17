package pl.com.bottega.dms.application;

import pl.com.bottega.dms.model.DocumentNumber;

/**
 * Created by anna on 12.02.2017.
 */
public interface DocumentCatalog {

    DocumentSearchResults find(DocumentQuery documentQuery);
    DocumentDTO get(DocumentNumber documentNumber);
}
