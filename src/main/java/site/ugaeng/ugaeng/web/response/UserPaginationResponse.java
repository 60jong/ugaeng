package site.ugaeng.ugaeng.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPaginationResponse {

    private final Long userId;
    private final String username;
}
