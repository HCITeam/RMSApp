package dao;

import entity.User;

/**
 * Created by mj on 16/11/5.
 */

public interface UserDAO extends BaseDAO<User>{
    public User getUser(String userName);
    //public UserEntity getUserByID(int id);
}
