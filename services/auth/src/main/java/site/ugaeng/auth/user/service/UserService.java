package site.ugaeng.auth.user.service;

import site.ugaeng.auth.user.entity.User;
import site.ugaeng.auth.user.service.dto.UserJoinParams;

public interface UserService {

  Long joinUser(final UserJoinParams params);

  User findByEmail(final String email);

  String findUsernameById(final Long userId);
}
