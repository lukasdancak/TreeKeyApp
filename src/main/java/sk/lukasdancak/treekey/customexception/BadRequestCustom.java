package sk.lukasdancak.treekey.customexception;

import org.springframework.http.HttpStatus;

public class BadRequestCustom extends RuntimeException {
    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestCustom(String message) {
        super(message);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
