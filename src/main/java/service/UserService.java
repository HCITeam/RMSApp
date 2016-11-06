package service;

/**
 * Created by mj on 16/11/5.
 */
import entity.User;
public interface UserService {
    public boolean addUser(User userEntity);
    public boolean deleteUser(int id);
    public boolean updateUser();
    public User findUser(String name);
}
