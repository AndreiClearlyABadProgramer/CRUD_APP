package CRUD.Controller;

import CRUD.model.User;
import CRUD.service.UserService;
import CRUD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService service = new UserServiceImpl();

    @GetMapping(value = "/Users")
    public String User(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("userList", service.userList());
        return "Users";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        if(user.getId() == null) {
            service.addUser(user);
        } else {
            service.updateUser(user);
        }
        return "redirect:/Users";
    }

    @RequestMapping("/Remove/{id}")
    public String remove(@PathVariable("id") long id){
        service.deleteUser(id);
        return "redirect:/Users";
    }

    @RequestMapping("/Edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("user", service.getUserById(id));
        model.addAttribute("userList", service.userList());
        return "redirect:/Users";
    }
}
