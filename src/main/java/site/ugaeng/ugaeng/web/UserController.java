package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.service.user.UserService;
import site.ugaeng.ugaeng.web.response.UserInfoResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/info")
    public String userInfo(@PathVariable Long userId, Model model) {

        User user = userService.find(userId);

        model.addAttribute("userInfoResponse", new UserInfoResponse(user));
        return "users/userInfo";
    }

    @GetMapping("")
    public String all(Model model) {
        List<UserInfoResponse> allInfo = userService.findAll()
                                                    .stream()
                                                    .map(UserInfoResponse::new)
                                                    .toList();
        model.addAttribute("allInfo", allInfo);
        return "users/allInfo";
    }
}
