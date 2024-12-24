package site.ugaeng.auth.user.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.ugaeng.auth.user.entity.User;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Override
    public Long save(final User user) {
        em.persist(user);
        return user.getId();
    }

    @Override
    public User findById(final Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
            .getResultList();
    }

    @Override
    public User findByEmail(final String email) {
        return em.createQuery("select m from User m where m.authInfo.email = :email", User.class)
            .setParameter("email", email)
            .getSingleResult();
    }

    @Override
    public String findUsernameById(Long userId) {
        return em.createQuery("select m.name from User m where m.id = :id", String.class)
            .setParameter("id", userId)
            .getSingleResult();
    }
}
