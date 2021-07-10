package Dao;

import Pojo.Role;
import Pojo.User;

import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
public interface UserDao {
    List<User> queryForList();

    List<Role> queryByUserRole(Long id);

    void save(User user);

    void saveUserRole(Long id, Long[] roleIds);

    List<User> queryForOne(String username);

    void del(Long userId);

    void delUserRole(Long userId);

    User queryByNameAndId(String username, String password);
}
