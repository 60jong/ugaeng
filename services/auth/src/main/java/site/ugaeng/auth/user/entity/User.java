package site.ugaeng.auth.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.ugaeng.auth.auth.entity.AuthInfo;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private AuthInfo authInfo;

  public User(String name, AuthInfo authInfo) {
    this.name = name;
    this.authInfo = authInfo;
  }
}
