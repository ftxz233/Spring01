package Service;

import Pojo.User;

import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
public interface UserService {
    List<User> queryForList();

    void save(User user, Long[] roleIds);

    void del(Long userId);

    User queryByNameAndId(String username, String password);
}
