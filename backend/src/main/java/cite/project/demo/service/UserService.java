package cite.project.demo.service;

import cite.project.demo.DTO.CreateUserDTO;
import cite.project.demo.DTO.UpdateUserDTO;
import cite.project.demo.enums.StatusEnum;
import cite.project.demo.repository.UserRepository;
import cite.project.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    //Создать юзера нового
    @Transactional
    public User createUser(CreateUserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setGender(userDTO.getGender());

        return userRepository.save(user);
    }

    //Получить всех юзеров списком
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Получить юзера по id
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент с ID " + id + " не найден")
        );
    }
    //Удалить
    @Transactional
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент с ID " + id + " не найден");
        }
    }
    //Заменить данные юзера
    @Transactional
    public User putUser(Long id, UpdateUserDTO newUserData) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент с ID " + id + " не найден")
        );

        String fullName = newUserData.getFullName();
        String gender = newUserData.getGender();
        StatusEnum status = newUserData.getStatus();

        if (fullName != null) {
            user.setFullName(fullName);
        }
        if (gender != null) {
            user.setGender(gender);
        }

        if (status != null) {
            user.setStatus(status);
        }

        return userRepository.save(user);
    }
}
