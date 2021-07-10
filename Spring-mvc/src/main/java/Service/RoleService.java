package Service;

import Pojo.Role;

import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
public interface RoleService {
    List<Role> query();

   void save(Role role);
}
