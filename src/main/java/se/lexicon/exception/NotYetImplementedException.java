package se.lexicon.exception;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException() {
    }

    public NotYetImplementedException(String message) {
        super(message);
    }
}
