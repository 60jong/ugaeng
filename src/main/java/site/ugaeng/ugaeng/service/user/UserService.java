package site.ugaeng.ugaeng.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.product.UsernameChanger;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.exception.ChangingToIdenticalUsernameException;
import site.ugaeng.ugaeng.exception.DuplicateUsernameException;
import site.ugaeng.ugaeng.exception.UserNotFoundException;
import site.ugaeng.ugaeng.repository.UserRepository;
import site.ugaeng.ugaeng.service.OrderService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private static final int WELCOME_POINTS = 50;

    private final OrderService orderService;

    private final UserRepository userRepository;

    @Transactional
    public void join(User user) {

        userRepository.save(user);

        afterJoin(user);
    }

    private void afterJoin(User user) {
        log.info("new user joined, USERNAME : {}", user.getUsername());
        user.plusPoint(WELCOME_POINTS);
    }

    public User findByUsername(String username) {

        return userRepository.findByUsername(username)
                             .orElseThrow();
    }

    public boolean existsByUsername(String username) {

        return userRepository.findByUsername(username)
                             .isPresent();
    }

    public User findById(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public String changeUsername(Long userId, String requestName) {

        User user = findById(userId);

        validateUsernameChangeable(user, requestName);

        orderService.createOrder(user, UsernameChanger.getInstance());
        user.changeUsername(requestName);

        return requestName;
    }

    private void validateUsernameChangeable(User user, String requestName) {

        if (user.getUsername().equals(requestName)) {
            throw new ChangingToIdenticalUsernameException(user.getUsername());
        }

        if (userRepository.existsByUsername(requestName)) {
            throw new DuplicateUsernameException(requestName);
        }
    }

}
