package site.ugaeng.ugaeng.repository;

import org.springframework.data.domain.Page;
import site.ugaeng.ugaeng.web.response.UserPaginationResponse;

public interface UserPaginationRepository {

    Page<UserPaginationResponse> findPageByCursor(Long cursorPostId, int size);
}
