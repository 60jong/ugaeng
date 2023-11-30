package site.ugaeng.ugaeng;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class InitManager {

    private final UserRepository userRepository;

    @Transactional
    @EventListener
    public void afterInitialize(ApplicationReadyEvent event) {
        // test users
        User testUser1 = new User("test1", "password1");
        User testUser2 = new User("test2", "password2");

        userRepository.save(testUser1);
        userRepository.save(testUser2);
    }

}
