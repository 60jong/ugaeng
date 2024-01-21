package site.ugaeng.ugaeng.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import site.ugaeng.ugaeng.web.response.UserPaginationResponse;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserPaginationRepositoryImpl implements UserPaginationRepository {

    private final EntityManager em;

    @Override
    public Page<UserPaginationResponse> findPageByCursor(Long cursorPostId, int size) {
        List<UserPaginationResponse> responses = getUserPaginationResponses(cursorPostId, size);

        return new PageImpl<>(responses);
    }

    private List<UserPaginationResponse> getUserPaginationResponses(Long cursorPostId, int size) {
        if (cursorPostId == null) {
            return getFirstPage(size);
        }
        return getNextPage(cursorPostId, size);
    }


    private List<UserPaginationResponse> getFirstPage(int size) {
        return em.createQuery("select new site.ugaeng.ugaeng.web.response.UserPaginationResponse(" +
                        "u.id, " +
                        "u.authInfo.username) " +
                        "from User u " +
                        "order by u.id asc", UserPaginationResponse.class)
                .setMaxResults(size)
                .getResultList();
    }

    private List<UserPaginationResponse> getNextPage(Long cursorPostId, int size) {
        return em.createQuery("select new site.ugaeng.ugaeng.web.response.UserPaginationResponse(" +
                        "u.id, " +
                        "u.authInfo.username) " +
                        "from User u " +
                        "where u.id > :cursor " +
                        "order by u.id asc ", UserPaginationResponse.class)
                .setParameter("cursor", cursorPostId)
                .setMaxResults(size)
                .getResultList();
    }
}
