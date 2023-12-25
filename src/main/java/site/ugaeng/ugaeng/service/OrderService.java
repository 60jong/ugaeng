package site.ugaeng.ugaeng.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.ugaeng.ugaeng.domain.Order;
import site.ugaeng.ugaeng.domain.Payment;
import site.ugaeng.ugaeng.domain.product.PointUsable;
import site.ugaeng.ugaeng.domain.user.User;
import site.ugaeng.ugaeng.repository.OrderRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final PaymentService paymentService;

    @Transactional
    public Order createOrder(User user, PointUsable usable) {

        Payment payment = paymentService.pay(user, usable.getPrice());

        Order order = Order.createPointUsableOrder(user, usable, payment);
        orderRepository.save(order);

        return order;
    }
}
