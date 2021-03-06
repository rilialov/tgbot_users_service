package users_service.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_service.dto.UserDTO;
import users_service.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    private UserConverter userConverter;

    @BeforeEach
    void init() {
        userConverter = new UserConverter();
    }

    @Test
    void userToUserDTO() {
        User user = new User(20, "First Name");

        UserDTO userDTO = userConverter.userToUserDTO(user);

        assertEquals(20, userDTO.getChatId());
        assertEquals("First Name", userDTO.getFirstName());
    }

    @Test
    void userDTOToUser() {
        UserDTO userDTO = new UserDTO(20, "First Name");

        User user = userConverter.userDTOToUser(userDTO);

        assertEquals(20, user.getChatId());
        assertEquals("First Name", user.getFirstName());
    }

    @Test
    void userListToDTOUserList() {
        List<User> list = new ArrayList<>();
        User user = new User(20, "First Name");
        list.add(user);

        List<UserDTO> dtoList = userConverter.userListToDTOUserList(list);

        assertEquals("First Name", dtoList.get(0).getFirstName());
    }

    @Test
    void userListDTOToUserList() {
        List<UserDTO> dtoList = new ArrayList<>();
        UserDTO user = new UserDTO(20, "First Name");
        dtoList.add(user);

        List<User> list = userConverter.userListDTOToUserList(dtoList);

        assertEquals("First Name", list.get(0).getFirstName());
    }
}