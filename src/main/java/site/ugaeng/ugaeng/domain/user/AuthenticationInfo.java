package site.ugaeng.ugaeng.domain.user;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class AuthenticationInfo {

    private String username;
    private String password;

    public AuthenticationInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
