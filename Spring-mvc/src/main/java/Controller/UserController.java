package Controller;

import Pojo.Role;
import Pojo.User;
import Service.RoleService;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<User> userList =  userService.queryForList();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(ModelAndView modelAndView) {
        List<Role> roleList = roleService.query();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable ("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.queryByNameAndId(username,password);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
