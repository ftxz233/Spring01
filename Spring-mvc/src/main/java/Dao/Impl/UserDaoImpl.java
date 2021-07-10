package Dao.Impl;

import Dao.UserDao;
import Pojo.Role;
import Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> queryForList() {
        return jdbcTemplate.query("select * from sys_user",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<Role> queryByUserRole(Long id) {
        return jdbcTemplate.query("select * from sys_role r, sys_user_role ur where ur.userId = ? and ur.roleId = r.id",new BeanPropertyRowMapper<Role>(Role.class),id);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
    }



    @Override
    public void saveUserRole(Long id, Long[] roleIds) {
        for(Long roleId:roleIds){
            jdbcTemplate.update("insert into sys_user_role values (?,?)",id,roleId);
        }
    }

    @Override
    public List<User> queryForOne(String username) {
        return jdbcTemplate.query("select * from sys_user u where u.username = ? ",new BeanPropertyRowMapper<User>(User.class),username);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user u where u.id = ?",userId);
    }

    @Override
    public void delUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role ur where ur.userId = ?",userId);
    }

    @Override
    public User queryByNameAndId(String username, String password){
        return jdbcTemplate.queryForObject("select * from sys_user u where u.username = ? and u.password = ?",new BeanPropertyRowMapper<User>(User.class),username,password);
    }
}
