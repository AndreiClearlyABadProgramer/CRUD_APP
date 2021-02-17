package CRUD.Controller;

import CRUD.dao.UserDao;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private final UserDao dao;

    public UserController(UserDao dao) {
        this.dao = dao;
    }


    @GetMapping(value = "/Users")
    public String User(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("userList", dao.userList());
        return "Users";
    }

    @PostMapping(value = "/Users")
    public String create(@ModelAttribute("user") User user){
        dao.addUser(user);
        return "redirect:/Users";
    }

    @GetMapping(value = "/Remove/{id}")
    public String remove(@PathVariable("id") long id){
        dao.deleteUser(id);
        return "redirect:/Users";
    }

    @GetMapping(value = "/{id}/Edit")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("User", dao.getUserById(id));
        return "Edit";
    }

    @PatchMapping("/{id}/Edit")
    public String update(@ModelAttribute("User") User user, @PathVariable("id") long id){
        dao.updateUser(id, user);
        return "redirect:/Users";
    }
}
