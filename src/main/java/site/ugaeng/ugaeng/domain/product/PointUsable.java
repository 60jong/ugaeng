package site.ugaeng.ugaeng.domain.product;

import lombok.Getter;

@Getter
public abstract class PointUsable {

    private String name;
    private int price;

    public PointUsable(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
