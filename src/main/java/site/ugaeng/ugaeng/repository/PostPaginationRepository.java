package site.ugaeng.ugaeng.repository;

import site.ugaeng.ugaeng.web.response.PostPaginationResponse;

import java.util.List;

public interface PostPaginationRepository {

    List<PostPaginationResponse> findAllByCursor(Long cursorPostId, int size);

    List<PostPaginationResponse> findAllByOffset(int offset, int size);
}
