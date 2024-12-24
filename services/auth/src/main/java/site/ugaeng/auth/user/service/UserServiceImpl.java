package site.ugaeng.auth.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ugaeng.auth.auth.entity.AuthInfo;
import site.ugaeng.auth.user.entity.User;
import site.ugaeng.auth.user.repository.UserRepository;
import site.ugaeng.auth.user.service.dto.UserJoinParams;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional
  public Long joinUser(final UserJoinParams params) {
    User user = new User(params.getName(),
        new AuthInfo(params.getEmail(), params.getPassword()));

    Long memberId = userRepository.save(user);

    log.info("New user [id : {}] joined", memberId);
    return memberId;
  }

  @Override
  public User findByEmail(final String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public String findUsernameById(final Long userId) {
    return userRepository.findUsernameById(userId);
  }
}
