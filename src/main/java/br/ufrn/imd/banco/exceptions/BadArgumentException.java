package br.ufrn.imd.banco.exceptions;

public class BadArgumentException extends Exception{

    private final String message;

    public BadArgumentException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
