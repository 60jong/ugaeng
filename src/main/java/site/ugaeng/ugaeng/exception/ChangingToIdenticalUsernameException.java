package site.ugaeng.ugaeng.exception;

public class ChangingToIdenticalUsernameException extends UgaengException {

    private static final String MESSAGE = "똑같은 username입니다.";

    private final String requestName;

    public ChangingToIdenticalUsernameException(String requestName) {
        super(MESSAGE);
        this.requestName = requestName;
    }
}
