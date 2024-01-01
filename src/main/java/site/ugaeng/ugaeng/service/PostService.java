package site.ugaeng.ugaeng.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.ugaeng.ugaeng.domain.Post;
import site.ugaeng.ugaeng.repository.PostRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {

        return postRepository.findAll();
    }

    public List<Post> findAllFetchAuthor() {

        return postRepository.findAllFetchAuthor();
    }
}
