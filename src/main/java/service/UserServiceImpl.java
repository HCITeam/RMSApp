package service;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mj on 16/11/5.
 */
@Service
@Transactional
public class UserServiceImpl implements  UserService {
    
    
    private UserDAO userDAO;
    
    public UserServiceImpl(){
        userDAO=new UserDAOImpl();
    }
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
    public UserEntity findUser(String name){
        return  userDAO.getUser(name);
    }
    
    
}
