package site.ugaeng.ugaeng.web.response;

import lombok.Getter;
import site.ugaeng.ugaeng.domain.user.User;

@Getter
public class UserInfoResponse {

    private final Long userId;
    private final String username;

    public UserInfoResponse(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }
}
