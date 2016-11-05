package dao;

/**
 * Created by mj on 16/11/5.
 */
import entity.UserEntity;
public interface UserDAO extends BaseDAO<UserEntity>{
    public UserEntity getUser(String userName);
    //public UserEntity getUserByID(int id);
}
