package site.ugaeng.ugaeng.web.response;

import lombok.Getter;
import site.ugaeng.ugaeng.domain.user.User;

@Getter
public class SignUpResponse {

    private final Long userId;

    public SignUpResponse(User user) {
        this.userId = user.getId();
    }
}
