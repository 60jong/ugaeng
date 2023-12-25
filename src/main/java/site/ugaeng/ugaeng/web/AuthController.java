package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.ugaeng.ugaeng.service.auth.AuthService;
import site.ugaeng.ugaeng.service.auth.SignInRequest;
import site.ugaeng.ugaeng.service.auth.SignUpRequest;
import site.ugaeng.ugaeng.web.response.SignInResponse;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
@Controller
public class AuthController {

    private final AuthService authService;

    //== Sign Up ==//
    @GetMapping("/signup")
    public String signUpForm(final Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "auth/signUpForm";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute final SignUpRequest request) {
        authService.signUp(request);
        return "redirect:/auth/signin";
    }

    //== Sign In ==//
    @GetMapping("/signin")
    public String signInForm(final Model model) {
        model.addAttribute("signInRequest", new SignInRequest());
        return "auth/signInForm";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute final SignInRequest request, final RedirectAttributes attributes) {
        SignInResponse response = authService.signIn(request);

        attributes.addAttribute("userId", response.getUserId());
        return "redirect:/users/{userId}/info";
    }
}
