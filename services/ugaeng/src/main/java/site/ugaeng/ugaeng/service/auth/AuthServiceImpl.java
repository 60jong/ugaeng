package site.ugaeng.ugaeng.service.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import site.ugaeng.ugaeng.service.auth.dto.UserIdResponse;
import site.ugaeng.ugaeng.service.auth.dto.UsernameResponse;

@Service
public class AuthServiceImpl implements AuthService {

    private final RestTemplate restTemplate;

    public AuthServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Long validateSession(String sessionId) {
        ResponseEntity<UserIdResponse> responseEntity = restTemplate.getForEntity(
            "http://localhost:8081/api/session/validate", UserIdResponse.class);

        return responseEntity.getBody().getUserId();
    }

    @Override
    public String getUsername(final Long userId) {
        ResponseEntity<UsernameResponse> responseEntity = restTemplate.getForEntity(
            "http://localhost:8081/api/users/{}/name".formatted(userId), UsernameResponse.class);

        return responseEntity.getBody().getUsername();
    }
}
