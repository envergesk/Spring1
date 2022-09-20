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
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;


//   @GetMapping
//   public String listPage(@RequestParam Optional<String> usernameFilter, Model model) {
//       if (usernameFilter.isEmpty() || usernameFilter.get().isBlank()) {
//           model.addAttribute("users", userRepository.findAll());
//       } else {
//           model.addAttribute("users", userRepository.findAllByUsernameLike("%" + usernameFilter.get() + "%"));
//       }
//       return "user";
//   }

    @GetMapping
    public String listPage(@RequestParam(required = false) String usernameFilter, Model model) {
        usernameFilter = usernameFilter == null || usernameFilter.isBlank() ? null : "%" + usernameFilter.trim() + "%";
        model.addAttribute("users", userRepository.userByUsername(usernameFilter));
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        userRepository.deleteById(id);
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
        userRepository.save(user);
        return "redirect:/user";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userRepository.save(user);
        return "redirect:/user";
    }


}
