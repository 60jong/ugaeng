package site.ugaeng.ugaeng.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import site.ugaeng.ugaeng.web.response.PostPaginationResponse;

import java.util.List;

@SpringBootTest
class PostPaginationRepositoryTest {

    @Autowired
    PostPaginationRepository postPaginationRepository;

    @Test
    @DisplayName("기존의 offset 방식")
    void offset_방식() {
        // given
        int offset = 100000;
        int size = 10;

        // when
        List<PostPaginationResponse> posts = postPaginationRepository.findAllByOffset(offset, size);

        // then

    }

    @Test
    void no_offset_방식() {
        // given
        Long cursorPostId = 100000L;
        int size = 10;

        // when
        List<PostPaginationResponse> posts = postPaginationRepository.findAllByCursor(cursorPostId, size);

        // then

    }
}