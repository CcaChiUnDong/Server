package com.ssafit.global.error;

public class SSafitException extends RuntimeException {

    public SSafitException() {
        super();
    }

    public SSafitException(final String message) {
        super(message);
    }

    public SSafitException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SSafitException(final Throwable cause) {
        super(cause);
    }
}
