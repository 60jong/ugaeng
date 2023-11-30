package site.ugaeng.ugaeng.service.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.service.user.UserService;
import site.ugaeng.ugaeng.web.SignInResponse;
import site.ugaeng.ugaeng.web.response.SignUpResponse;

/**
 * Facade
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AuthService {

    private final UserService userService;

    public SignUpResponse signUp(SignUpRequest request) {

        validateSignUp(request);

        User user = request.toEntity();
        userService.join(user);

        return new SignUpResponse(user);
    }

    private void validateSignUp(SignUpRequest request) {
        // username existence
        if (usernameExists(request.getUsername())) {
            throw new RuntimeException();
        }
    }

    public SignInResponse signIn(SignInRequest request) {

        validateSignIn(request);

        User user = userService.find(request.getUsername());
        return new SignInResponse(user);
    }

    private void validateSignIn(SignInRequest request) {
        // username existence
        if (!usernameExists(request.getUsername())) {
            throw new RuntimeException();
        }
    }

    private boolean usernameExists(String username) {
        return userService.exist(username);
    }
}
