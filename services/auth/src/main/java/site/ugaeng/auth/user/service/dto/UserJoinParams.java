package site.ugaeng.auth.user.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserJoinParams {

  private final String name;
  private final String email;
  private final String password;
}
