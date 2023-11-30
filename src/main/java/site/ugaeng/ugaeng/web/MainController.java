package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.ugaeng.ugaeng.repository.UserRepository;
import site.ugaeng.ugaeng.web.response.UserInfoResponse;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<UserInfoResponse> users = userRepository.findAll()
                .stream()
                .map(UserInfoResponse::new)
                .toList();

        model.addAttribute("users", users);
        return "home";
    }

}
