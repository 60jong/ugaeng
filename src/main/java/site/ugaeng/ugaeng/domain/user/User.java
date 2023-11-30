package site.ugaeng.ugaeng.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.ugaeng.ugaeng.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AuthenticationInfo authInfo;

    @Embedded
    private PersonalInfo personalInfo;

    public User(String username, String password) {
        this.authInfo = new AuthenticationInfo(username, password);
    }

    //== GETTER ==//
    public String getUsername() {
        return this.authInfo.getUsername();
    }
}
