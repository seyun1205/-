import front.all.pojo.Users;
import front.all.service.UserService;
import front.all.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class test {
    private UserService userService = new UserServiceImpl();

    @Test
    public void add() {
        Users users = new Users();
        users.setUsername("123");
        users.setPassword("123");
        users.setIdentify(1);
        userService.add(users);
    }
}
