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
    public User addUser(User user) {
        userDAO.add(user);
        return (User)userDAO.getNewAddedEntity();
        
    }
    
    @Override
    public boolean deleteUser(User user) {
        userDAO.delete(user);
        return true;
    }
    
    @Override
    public boolean updateUser(User user) {
        userDAO.update(user);
        return true;
    }
    
    @Override
    public User findUserByName(String name){
        return  userDAO.getUserByName(name);
    }
    
    @Override
    public User findUserByID(int id){
        return  userDAO.getUserByID(id);
    }
    
    @Override
    public User login(String name,String password){
        User user=userDAO.getUserByName(name);
        if(user.getPassword().equals(password)){
            return user;
        }
        return  null;
    }
    @Override
    public User register(String name,String password){
        User user=userDAO.getUserByName(name);
        if(user!=null){
            return null;
        }
        User newUser=new User();
        newUser.setName(name);
        newUser.setPassword(password);
        userDAO.add(newUser);
        newUser=(User)userDAO.getNewAddedEntity();
        return  newUser;
    }
}
