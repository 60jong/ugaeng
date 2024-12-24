package site.ugaeng.auth.auth.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;
import site.ugaeng.auth.auth.entity.AuthInfo;
import site.ugaeng.auth.user.entity.User;
import site.ugaeng.auth.user.service.UserService;
import site.ugaeng.auth.user.service.dto.UserJoinParams;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Override
    @Transactional
    public Long signUp(final SignUpParams params) {
        Long memberId = userService.joinUser(
            new UserJoinParams(params.getUsername(), params.getEmail(), params.getPassword()));

        log.info("User [id : {}] signed up successfully", memberId);
        return memberId;
    }

    @Override
    public Long signIn(final SignInParams params) {
        final String email = params.getEmail();
        final String password = params.getPassword();

        final User user = userService.findByEmail(email);
        final AuthInfo authInfo = user.getAuthInfo();

        if (authInfo.matchPassword(password)) {
            log.info("User [id : {}] is authenticated.", user.getId());
            return user.getId();
        }
        return null;
    }
}
