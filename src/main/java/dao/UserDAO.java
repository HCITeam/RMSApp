package dao;

import entity.User;

/**
 * Created by mj on 16/11/5.
 */

public interface UserDAO extends BaseDAO<User>{
    public User getUserByName(String userName);
    public User getUserByID(int id);
}
