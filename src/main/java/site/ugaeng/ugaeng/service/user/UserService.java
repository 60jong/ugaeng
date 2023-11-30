package site.ugaeng.ugaeng.service.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.item.Item;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager em;

    @Transactional
    public void join(User user) {
        userRepository.save(user);
        log.info("new user joined, USERNAME : {}", user.getUsername());
    }

    public User find(String username) {
        return userRepository.findByUsername(username)
                             .orElseThrow();
    }

    public boolean exist(String username) {
        return userRepository.findByUsername(username)
                             .isPresent();
    }

    public User find(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void saveItem(Item item) {
        em.persist(item);
    }
}
