package site.ugaeng.ugaeng.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.ugaeng.ugaeng.domain.user.User;

@Getter
@AllArgsConstructor
public class SignInResponse {

    private Long userId;

    public SignInResponse(User user) {
        this.userId = user.getId();
    }
}
