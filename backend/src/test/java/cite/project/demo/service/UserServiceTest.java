package cite.project.demo.service;


import cite.project.demo.DTO.CreateUserDTO;
import cite.project.demo.DTO.StubValues;
import cite.project.demo.DTO.UpdateUserDTO;
import cite.project.demo.enums.StatusEnum;
import cite.project.demo.model.User;
import cite.project.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static final String GENDER_STUB = "m";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void createUserSuccess(){
        CreateUserDTO dto = new CreateUserDTO();
        dto.setFullName("Иванов Иван Иванович");
        dto.setGender("m");

        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setStatus(StatusEnum.ACTIVE);
        expectedUser.setGender("m");
        expectedUser.setFullName("Иванов Иван Иванович");

        when(userRepository.save(any(User.class))).thenReturn(expectedUser);


        //2

        User actualUser = userService.createUser(dto);

        assertNotNull(actualUser);
        assertEquals(1L, actualUser.getId());
        assertEquals("Иванов Иван Иванович", actualUser.getFullName());
        assertEquals("m", actualUser.getGender());
        assertEquals(StatusEnum.ACTIVE, actualUser.getStatus());

        verify(userRepository, times(1)).save(any(User.class));

    }

    @Test
    void deleteUserNotFound(){

        Long wrongId = 100L;

        when(userRepository.existsById(wrongId)).thenReturn(false);

        //2

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.deleteUserById(wrongId)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());

        verify(userRepository, never()).deleteById(any());

    }

    @Test
    void deleteUserSuccess(){

        Long validId = 1L;

        when(userRepository.existsById(validId)).thenReturn(true);

        userService.deleteUserById(validId);

        verify(userRepository, times(1)).deleteById(validId);
    }


    @Test
    void getAllUsersReturnList(){

        List<User> userList = new ArrayList<>();

        User userFirst = new User();
        userFirst.setId(1L);
        userFirst.setGender("m");
        userFirst.setFullName("Ivan");


        User userSecond = new User();
        userSecond.setFullName("Oleg");
        userSecond.setId(2L);
        userSecond.setGender("f");


        userList.add(userFirst);
        userList.add(userSecond);


        when(userRepository.findAll()).thenReturn(userList);

        assertEquals(userList, userService.getAllUsers());

        verify(userRepository, times(1)).findAll();

    }

    @Test
    void getUserByIdSuccess(){



        User userExpected = new User();
        userExpected.setFullName("Ivan");
        userExpected.setId(StubValues.STUB_LONG);
        userExpected.setGender("m");

        when(userRepository.findById(StubValues.STUB_LONG)).thenReturn(Optional.of(userExpected));


        assertEquals(userExpected, userService.getUser(StubValues.STUB_LONG));

        verify(userRepository, times(1)).findById(StubValues.STUB_LONG);

    }


    @Test
    void getUserByIdFailedNotFound(){

        when(userRepository.findById(StubValues.STUB_LONG)).thenReturn(Optional.empty());


        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> userService.getUser(StubValues.STUB_LONG)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());

    }
//TODO:Сделать тест

//    @Test
//    void replaceUserSuccess(){
//
//        User userOriginal = new User();
//        UpdateUserDTO dto = new UpdateUserDTO();
//
//
//
//
//
//
//



}
