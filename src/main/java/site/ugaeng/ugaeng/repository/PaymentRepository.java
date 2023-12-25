package site.ugaeng.ugaeng.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.ugaeng.ugaeng.domain.Payment;

@RequiredArgsConstructor
@Repository
public class PaymentRepository {

    private final EntityManager em;

    public Payment save(Payment payment) {

        em.persist(payment);

        return payment;
    }
}
