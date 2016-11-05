package service;

/**
 * Created by mj on 16/11/5.
 */
import entity.UserEntity;
public interface UserService {
    public boolean addUser(UserEntity userEntity);
    public boolean deleteUser(int id);
    public boolean updateUser();
    public UserEntity findUser(String name);
}
