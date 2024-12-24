package site.ugaeng.auth.user.repository;

import site.ugaeng.auth.user.entity.User;

import java.util.List;

public interface UserRepository {

    Long save(final User user);

    User findById(final Long id);

    List<User> findAll();

    User findByEmail(final String email);

    String findUsernameById(final Long userId);
}
