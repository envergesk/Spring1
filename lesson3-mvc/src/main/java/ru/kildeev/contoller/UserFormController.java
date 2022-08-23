package ru.kildeev.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kildeev.persist.User;
import ru.kildeev.persist.UserRepository;

@Controller
@RequestMapping ("/user_form")
@RequiredArgsConstructor
public class UserFormController {

    private UserRepository userRepository;

    @GetMapping("/add")
    public String addUser(Model model) {
//      User user = new User ("new User");
//      userRepository.insert(user);
//      model.addAttribute("", user);
        model.addAttribute("user", new User(""));
        return "user_form";
    }


}
