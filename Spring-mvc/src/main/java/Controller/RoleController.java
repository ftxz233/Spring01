package Controller;

import Pojo.Role;
import Service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Rookie
 * @Date 2021/7/8
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Role> roleList = roleService.query();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }
}
