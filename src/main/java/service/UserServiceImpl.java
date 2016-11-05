package service;

import dao.UserDAO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mj on 16/11/5.
 */
@Service
@Transactional
public class UserServiceImpl implements  UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public boolean addUser(UserEntity userEntity) {
       
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
    public UserEntity findUser(String name){
        return  userDAO.getUser(name);
    }
    
    
}
