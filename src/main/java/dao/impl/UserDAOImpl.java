package dao.impl;

import dao.UserDAO;
import entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by mj on 16/11/5.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {
    public UserEntity getUser(String userName){
       return  getByColumn("name","zch");
    }
}
