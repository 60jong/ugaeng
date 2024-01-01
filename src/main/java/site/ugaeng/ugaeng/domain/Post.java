package site.ugaeng.ugaeng.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.ugaeng.ugaeng.domain.user.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    private int viewCount;
    private int commentCount;
}