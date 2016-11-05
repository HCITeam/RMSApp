package service.impl;

import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.User;
import service.UserService;

/**
 * Created by mj on 16/11/5.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    

    @Autowired
    private UserDAO userDAO;
    
    @Override
    public boolean addUser(User user) {
       
        userDAO.add(user);
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
    public User findUser(String name){
        return  userDAO.getUser(name);
    }
    
    
}
