package site.ugaeng.ugaeng.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.ugaeng.ugaeng.domain.Post;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager em;

    @Override
    public List<Post> findAll() {

        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public Post save(Post post) {

        em.persist(post);

        return post;
    }

    @Override
    public List<Post> findAllFetchAuthor() {

        return em.createQuery("select p from Post p join fetch p.author", Post.class)
                .getResultList();
    }

}
