package cite.project.demo.controller;

import cite.project.demo.DTO.CreateUserDTO;
import cite.project.demo.DTO.UpdateUserDTO;
import cite.project.demo.service.UserService;
import cite.project.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
// Сделать lombok, liquidbase

@RestController
@RequestMapping(value = "/api/cards")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public User create(@Valid @RequestBody CreateUserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User readUser(@PathVariable Long id) {
        return  userService.getUser(id);
    }

    @PutMapping(value = "/{id}")
    public User replaceUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO user) {
        return  userService.putUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
             userService.deleteUserById(id);
    }


}

