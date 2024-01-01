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

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
