package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.service.ProfileParam;
import site.ugaeng.ugaeng.service.auth.SignInRequest;
import site.ugaeng.ugaeng.service.user.UserService;
import site.ugaeng.ugaeng.web.response.UserInfoResponse;
import site.ugaeng.ugaeng.web.response.UserProfileResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/info")
    public String userInfo(@PathVariable Long userId, Model model) {

        User user = userService.findById(userId);

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

    @GetMapping("/{userId}/profile")
    public String profile(@PathVariable Long userId, Model model) {

        User user = userService.findById(userId);

        model.addAttribute("userProfileResponse", new UserProfileResponse(user));

        return "users/profile";
    }

    @GetMapping("/{userId}/profile/edit")
    public String profileEditForm(@PathVariable Long userId, Model model) {

        User user = userService.findById(userId);

        model.addAttribute("userProfileResponse", new UserProfileResponse(user));

        return "users/profileEditForm";
    }

    @PostMapping("/{userId}/profile/edit")
    public String editProfile(@PathVariable Long userId, @ModelAttribute ProfileParam param) {

        userService.changeUsername(userId, param.getUsername());

        return "redirect:/users/{userId}/profile";
    }
}
