package sk.lukasdancak.treekey.customexception;

import org.springframework.http.HttpStatus;

public class DbComunicationProblemCustom extends RuntimeException {
    private final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public DbComunicationProblemCustom(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }
}
