package site.ugaeng.ugaeng.domain.product;

public class UsernameChanger extends PointUsable {

    private static final UsernameChanger SINGLETON_OBJECT =
            new UsernameChanger("USERNAME_CHANGER", 50);

    private UsernameChanger(String name, int price) {
        super(name, price);
    }

    public static UsernameChanger getInstance() {
        return SINGLETON_OBJECT;
    }
}
