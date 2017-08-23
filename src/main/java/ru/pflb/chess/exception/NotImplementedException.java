package ru.pflb.chess.exception;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super("Операция пока не поддерживается");
    }
}
