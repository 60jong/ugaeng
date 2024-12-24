package site.ugaeng.ugaeng.service.auth;

public interface AuthService {
    Long validateSession(final String sessionId);

    String getUsername(final Long userId);
}
