package ru.kildeev.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kildeev.persist.User;
import ru.kildeev.persist.UserRepository;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        userRepository.delete(id);
        return "redirect:/user";
    }


    @PostMapping
    public String saveUser(User user) {
        log.info("Method saveUser was hit");
        userRepository.update(user);
        return "redirect:/user";
    }

    public String updateUser(User user){
        userRepository.update(user);
        return "redirect:/user";
    }


}
