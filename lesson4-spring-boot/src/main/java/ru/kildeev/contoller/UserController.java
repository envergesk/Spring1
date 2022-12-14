package ru.kildeev.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kildeev.persist.User;
import ru.kildeev.persist.UserRepository;

import javax.validation.Valid;

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

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        userRepository.delete(id);
        return "redirect:/user";
    }


    @PostMapping
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_form";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            bindingResult.rejectValue("password", "password not match");
            return "user_form";
        }
        log.info("Method saveUser was hit");
        userRepository.update(user);
        return "redirect:/user";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userRepository.update(user);
        return "redirect:/user";
    }


}
