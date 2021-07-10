package Service.Impl;

import Dao.RoleDao;
import Pojo.Role;
import Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> query() {
        List<Role> roleList = roleDao.query();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

}
