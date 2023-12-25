package site.ugaeng.ugaeng.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.Payment;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.repository.PaymentRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment pay(User user, int amount) {

        Payment payment = new Payment(user, amount);
        paymentRepository.save(payment);

        return payment;
    }
}
