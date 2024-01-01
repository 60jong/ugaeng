package site.ugaeng.ugaeng.web.response;

import lombok.Getter;
import site.ugaeng.ugaeng.domain.Post;

@Getter
public class PostInfoResponse {

    private Long id;
    private String title;
    private String authorName;
    private int viewCount;
    private int commentCount;

    public PostInfoResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.authorName = post.getAuthor().getUsername();
        this.viewCount = post.getViewCount();
        this.commentCount = post.getCommentCount();
    }
}
