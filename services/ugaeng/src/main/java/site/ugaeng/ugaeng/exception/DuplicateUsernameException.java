package site.ugaeng.ugaeng.exception;

public class DuplicateUsernameException extends UgaengException {

    private static final String MESSAGE = "중복된 Username입니다.";

    public DuplicateUsernameException(String username) {
        super(MESSAGE);
    }
}
