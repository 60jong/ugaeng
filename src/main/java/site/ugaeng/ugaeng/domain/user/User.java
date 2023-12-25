package site.ugaeng.ugaeng.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AuthenticationInfo authInfo;

    private Integer point = 0;

    public User(String username, String password) {
        this.authInfo = new AuthenticationInfo(username, password);
    }

    //== GETTER ==//
    public String getUsername() {
        return this.authInfo.getUsername();
    }

    public boolean canPay(int price) {
        return point >= price;
    }

    public void pay(int price) {
        this.point -= price;
    }

    public void changeUsername(String requestName) {
        this.authInfo = new AuthenticationInfo(requestName, authInfo.getPassword());
    }

    public void plusPoint(int point) {
        this.point += point;
    }
}
