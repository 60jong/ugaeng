package site.ugaeng.ugaeng.service.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.ugaeng.ugaeng.domain.user.User;

@Getter @Setter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User toEntity() {
        return new User(username, password);
    }
}
