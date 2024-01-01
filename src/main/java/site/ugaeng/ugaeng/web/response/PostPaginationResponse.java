package site.ugaeng.ugaeng.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostPaginationResponse {

    private Long postId;
    private String title;
    private String authorName;
    private int viewCount;
    private int commentCount;
}
