package site.ugaeng.ugaeng.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import site.ugaeng.ugaeng.domain.user.User;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User payer;

    private int amount;

    public Payment(User payer, int amount) {

        if (!payer.canPay(amount)) {
            throw new PaymentFailedException(payer.getId(), amount);
        }

        this.payer = payer;
        payer.pay(amount);
        this.amount = amount;
    }
}
