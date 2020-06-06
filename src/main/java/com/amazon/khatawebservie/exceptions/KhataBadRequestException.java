package com.amazon.khatawebservie.exceptions;

/**
 *  Exception class to throw BadRequest if parameter is not found
 */
public class KhataBadRequestException extends Exception {
    private static final long serialVersionUID = 1L;

    public KhataBadRequestException() {
        super();
    }

    public KhataBadRequestException(String message) {
        super(message);
    }

    public KhataBadRequestException(String message, Throwable t) {
        super(message, t);
    }

    public KhataBadRequestException(Throwable t) {
        super(t);
    }
}
