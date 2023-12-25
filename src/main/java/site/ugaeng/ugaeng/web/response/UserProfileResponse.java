package site.ugaeng.ugaeng.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.ugaeng.ugaeng.domain.user.User;

@Getter
@AllArgsConstructor
public class UserProfileResponse {

    private Long id;
    private String username;

    public UserProfileResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
