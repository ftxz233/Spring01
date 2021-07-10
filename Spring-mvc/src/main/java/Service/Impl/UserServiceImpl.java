package Service.Impl;

import Dao.UserDao;
import Pojo.Role;
import Pojo.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryForList() {
        List<User> userList = userDao.queryForList();
        for(User user:userList){
            List<Role> roles = userDao.queryByUserRole(user.getId());
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        userDao.save(user);
        List<User> userList = userDao.queryForOne(user.getUsername());
        userDao.saveUserRole(userList.get(0).getId(),roleIds);
    }

    @Override
    public void del(Long userId) {
        userDao.delUserRole(userId);
        userDao.del(userId);
    }

    @Override
    public User queryByNameAndId(String username, String password) {
        try {
            User user = userDao.queryByNameAndId(username,password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
