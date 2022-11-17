package front.all.service;



import front.all.pojo.Users;

import java.util.List;

public interface UserService {
    Users getUsersByUsername(String username);
    List<Users> getAll();
}
