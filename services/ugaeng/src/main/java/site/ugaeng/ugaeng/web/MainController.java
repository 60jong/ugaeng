package site.ugaeng.ugaeng.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.ugaeng.ugaeng.service.auth.AuthService;


@RequiredArgsConstructor
@Controller
public class MainController {
    private final AuthService authService;

    @GetMapping("/")
    public String home(HttpServletRequest httpRequest, Model model) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            Cookie sessionIdCookie = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("JSESSIONID"))
                .findAny()
                .orElse(null);

            if (sessionIdCookie != null) {
                final String sessionId = sessionIdCookie.getValue();
                final Long userId = authService.validateSession(sessionId);
                if (userId != -1) {
                    final String username = authService.getUsername(userId);
                    if (username != null) {
                        model.addAttribute("username", username);
                    }
                }
            }
        }

        return "home";
    }

}
