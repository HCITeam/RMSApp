package dao.impl;

import dao.UserDAO;
import org.springframework.stereotype.Repository;
import entity.User;
/**
 * Created by mj on 16/11/5.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    public User getUser(String userName){
       return  getByColumn("name",userName);
    }
}
