package service;

import dao.UserDAO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mj on 16/11/5.
 */
public class UserServiceImpl implements  UserService {
    
    @Autowired
    UserDAO userDAO;
    
    
    @Override
    public boolean addUser() {
        UserEntity userEntity=new UserEntity();
        userEntity.setName("lmj");
        userEntity.setName("123");
        userDAO.add(userEntity);
        return true;
    }
    
    @Override
    public boolean deleteUser(int id) {
        return false;
    }
    
    @Override
    public boolean updateUser() {
        return false;
    }
    
    @Override
    public void findUser() {
        
    }
    
    
}
