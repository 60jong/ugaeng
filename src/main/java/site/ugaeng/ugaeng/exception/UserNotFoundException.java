package site.ugaeng.ugaeng.exception;

public class UserNotFoundException extends UgaengException {

    private static final String MESSAGE = "존재하지 않는 USER 입니다.";

    private final Long userId;

    public UserNotFoundException(Long userId) {
        super(MESSAGE);
        this.userId = userId;
    }
}
