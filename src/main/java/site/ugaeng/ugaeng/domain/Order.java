package site.ugaeng.ugaeng.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import site.ugaeng.ugaeng.domain.product.PointUsable;
import site.ugaeng.ugaeng.domain.user.User;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;

    private String description;

    private LocalDateTime orderedAt;

    public Order(User user, PointUsable pointUsable, Payment payment) {
        this.user = user;
        this.description = pointUsable.getName();
        this.payment = payment;

        this.orderedAt = LocalDateTime.now();
    }

    public static Order createPointUsableOrder(User user, PointUsable pointUsable, Payment payment) {
        return new Order(user, pointUsable, payment);
    }
}