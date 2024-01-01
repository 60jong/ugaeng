package site.ugaeng.ugaeng.repository;

import site.ugaeng.ugaeng.domain.Post;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();

    Post save(Post post);

    List<Post> findAllFetchAuthor();
}
