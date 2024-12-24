package site.ugaeng.auth.auth.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.auth.auth.controller.api.dto.UsernameResponse;
import site.ugaeng.auth.auth.service.AuthService;
import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;
import site.ugaeng.auth.auth.controller.api.dto.UserIdResponse;
import site.ugaeng.auth.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AuthApiController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(final @RequestBody SignUpParams params,
        HttpServletRequest httpRequest) {
        Long userId = authService.signUp(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        session.setAttribute("userId", userId);
        log.info("Session [{}] for member [{}]", session.getId(), userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> signUp(final @RequestBody SignInParams params,
        HttpServletRequest httpRequest) {
        Long userId = authService.signIn(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        session.setAttribute("userId", userId);
        log.info("Session [{}] for member [{}]", session.getId(), userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/session/validate")
    public ResponseEntity<UserIdResponse> validateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        Long userId = -1L;
        if (session != null) {
            userId = (Long) session.getAttribute("userId");
            log.info("Validates session [{}] has an userId [{}]", session.getId(), userId);
        }
        log.info("UserId [{}]", userId);
        return ResponseEntity.ok().body(new UserIdResponse(userId));
    }

    @GetMapping("/users/{userId}/name")
    public ResponseEntity<UsernameResponse> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        Long userId = -1L;
        if (session != null) {
            userId = (Long) session.getAttribute("userId");
        }

        final String username = userService.findUsernameById(userId);

        return ResponseEntity.ok().body(new UsernameResponse(username));
    }
}
