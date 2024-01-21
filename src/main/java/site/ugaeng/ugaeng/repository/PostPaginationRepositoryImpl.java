package site.ugaeng.ugaeng.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import site.ugaeng.ugaeng.domain.Post;
import site.ugaeng.ugaeng.web.response.PostPaginationResponse;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PostPaginationRepositoryImpl implements PostPaginationRepository {

    private final EntityManager em;

    @Override
    public Page<PostPaginationResponse> findPageByCursor(Long cursorPostId, int size) {
        List<PostPaginationResponse> responses = getPostPaginationResponses(cursorPostId, size);

        return new PageImpl<>(responses);
    }

    private List<PostPaginationResponse> getPostPaginationResponses(Long cursorPostId, int size) {
        if (cursorPostId == null) {
            return getFirstPage(size);
        }
        return getNextPage(cursorPostId, size);
    }

    private List<PostPaginationResponse> getFirstPage(int size) {
       return em.createQuery("select new site.ugaeng.ugaeng.web.response.PostPaginationResponse(" +
                        "p.id," +
                        "p.title," +
                        "p.author.authInfo.username," +
                        "p.viewCount," +
                        "p.commentCount) " +
                        "from Post p join p.author " +
                        "order by p.id desc ", PostPaginationResponse.class)
                .setMaxResults(size)
                .getResultList();
    }

    private List<PostPaginationResponse> getNextPage(Long cursorPostId, int size) {
        return em.createQuery("select new site.ugaeng.ugaeng.web.response.PostPaginationResponse(" +
                        "p.id," +
                        "p.title," +
                        "p.author.authInfo.username," +
                        "p.viewCount," +
                        "p.commentCount) " +
                        "from Post p join p.author " +
                        "where p.id < :cursor " +
                        "order by p.id desc ", PostPaginationResponse.class)
                .setParameter("cursor", cursorPostId)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public List<PostPaginationResponse> findAllByOffset(int offset, int size) {

        return em.createQuery("select new site.ugaeng.ugaeng.web.response.PostPaginationResponse(" +
                        "p.id," +
                        "p.title," +
                        "p.author.authInfo.username," +
                        "p.viewCount," +
                        "p.commentCount) " +
                        "from Post p join p.author " +
                        "order by p.id desc ", PostPaginationResponse.class)
                .setFirstResult(offset)
                .setMaxResults(size)
                .getResultList();
    }
}
