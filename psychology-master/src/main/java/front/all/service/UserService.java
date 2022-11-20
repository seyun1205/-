package front.all.service;



import front.all.pojo.Users;

import java.util.List;

public interface UserService {
    Users getUsersByUsername(String username);
    List<Users> selectAll();
    boolean add(Users user);
    boolean deletename(String username);
    boolean change(String username,String password,int identify,String name);
}
