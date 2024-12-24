package site.ugaeng.auth.user.web.dto;

import lombok.Getter;
import lombok.Setter;
import site.ugaeng.auth.user.service.dto.UserJoinParams;

@Getter
@Setter
public class UserJoinRequest {
    private String name;
    private String email;
    private String password;

    // Converter method //
    public UserJoinParams toUserJoinParams() {
        return new UserJoinParams(this.name, this.email, this.password);
    }
}
