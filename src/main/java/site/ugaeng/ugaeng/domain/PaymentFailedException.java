package site.ugaeng.ugaeng.domain;

import site.ugaeng.ugaeng.exception.UgaengException;

public class PaymentFailedException extends UgaengException {

    private static final String MESSAGE = "잔여 포인트가 부족합니다.";

    public PaymentFailedException(Long userId, int amount) {
        super(MESSAGE);
    }
}
