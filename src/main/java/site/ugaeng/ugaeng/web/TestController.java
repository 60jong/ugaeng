package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.ugaeng.domain.item.Item;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.service.user.UserService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

    private final UserService userService;

    @GetMapping("/test/username")
    public String generateRandomUsers() {

        for (int i = 0; i < 100000; i++) {
            String s = RandomStringUtils.randomAlphanumeric(10);

            Item item = new Item(s, RandomUtils.nextInt(1000) * 100, RandomUtils.nextInt(1000));
            item.setSeller(userService.find((long) RandomUtils.nextInt(13000) + 1));
            userService.saveItem(item);
        }

        return "OK";
    }
}
