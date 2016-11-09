package service;

/**
 * Created by mj on 16/11/5.
 */
import entity.User;
public interface UserService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    public User addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public boolean deleteUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 用户名查询
     * @param name
     * @return
     */
    public User findUserByName(String name);

    /**
     * 用户id查询
     * @param id
     * @return
     */
    public User findUserByID(int id);

    /**
     * 登录逻辑
     * @param name
     * @param password
     * @return
     */
    public User login(String name,String password);

    /**
     * 用户注册
     * @param name
     * @param password
     * @return
     */
    public User register(String name,String password);
}
