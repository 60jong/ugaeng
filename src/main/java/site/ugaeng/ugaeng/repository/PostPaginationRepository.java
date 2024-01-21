package site.ugaeng.ugaeng.repository;

import org.springframework.data.domain.Page;
import site.ugaeng.ugaeng.web.response.PostPaginationResponse;

import java.util.List;

public interface PostPaginationRepository {

    Page<PostPaginationResponse> findPageByCursor(Long cursorPostId, int size);

    List<PostPaginationResponse> findAllByOffset(int offset, int size);
}
