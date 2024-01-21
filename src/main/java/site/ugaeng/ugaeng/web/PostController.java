package site.ugaeng.ugaeng.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.ugaeng.ugaeng.repository.PostPaginationRepository;
import site.ugaeng.ugaeng.service.PostService;
import site.ugaeng.ugaeng.web.response.PostInfoResponse;
import site.ugaeng.ugaeng.web.response.PostPaginationResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostController {

    private final PostPaginationRepository postPaginationRepository;

    @GetMapping("")
    public String allPosts(Model model,
                           @RequestParam(required = false) Long cursor,
                           @RequestParam(defaultValue = "10") int size
    ) {
        Page<PostPaginationResponse> postPages = postPaginationRepository.findPageByCursor(cursor, size);

        model.addAttribute("postPages", postPages);

        return "posts/allPosts";
    }
}
