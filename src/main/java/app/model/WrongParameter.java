package app.model;

public class WrongParameter extends Exception {
    public WrongParameter(String errorMessage) {
        super(errorMessage);
    }
}
