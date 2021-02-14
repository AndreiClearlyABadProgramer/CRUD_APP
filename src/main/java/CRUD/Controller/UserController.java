package CRUD.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping(value = "/Users")
    public String Users(@RequestParam(value = "count", required = false) Integer count, ModelMap model){

        return "User";
    }
}
