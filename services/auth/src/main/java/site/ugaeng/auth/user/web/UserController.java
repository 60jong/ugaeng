package site.ugaeng.auth.user.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.auth.user.service.UserService;
import site.ugaeng.auth.user.web.dto.UserJoinRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserJoinRequest request) {
        userService.joinUser(request.toUserJoinParams());

        return ResponseEntity.ok().build();
    }
}
