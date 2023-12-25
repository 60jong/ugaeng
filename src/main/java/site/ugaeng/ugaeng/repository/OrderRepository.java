package site.ugaeng.ugaeng.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.ugaeng.ugaeng.domain.Order;

@RequiredArgsConstructor
@Repository
public class OrderRepository {

    private final EntityManager em;

    public Order save(Order order) {

        em.persist(order);

        return order;
    }
}
