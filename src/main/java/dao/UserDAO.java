package dao;

import entity.User;

/**
 * Created by mj on 16/11/5.
 */

public interface UserDAO extends BaseDAO<User>{
    /**
     * 用户名查询
     * @param userName
     * @return
     */
    public User getUserByName(String userName);

    /**
     * 用户id查询
     * @param id
     * @return
     */
    public User getUserByID(int id);
}
