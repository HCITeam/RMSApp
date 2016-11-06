package service;

/**
 * Created by mj on 16/11/5.
 */
import entity.User;
public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(User user);
    public boolean updateUser(User user);
    public User findUserByName(String name);
    public User findUserByID(int id);
    public User login(String name,String password);
}
