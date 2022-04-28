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
        User user = new User("1af44f5e93", "test_nick", "First", "Last");

        UserDTO userDTO = userConverter.userToUserDTO(user);

        assertEquals("test_nick", userDTO.getNickname());
        assertEquals("First", userDTO.getFirstName());
        assertEquals("Last", userDTO.getLastName());
    }

    @Test
    void userDTOToUser() {
        UserDTO userDTO = new UserDTO("1af44f5e93", "test_nick", "First", "Last");

        User user = userConverter.userDTOToUser(userDTO);

        assertEquals("test_nick", user.getNickname());
        assertEquals("First", user.getFirstName());
        assertEquals("Last", user.getLastName());

    }

    @Test
    void userListToDTOUserList() {
        List<User> list = new ArrayList<>();
        User user = new User("1af44f5e93", "test_nick", "First", "Last");
        list.add(user);

        List<UserDTO> dtoList = userConverter.userListToDTOUserList(list);

        assertEquals("test_nick", dtoList.get(0).getNickname());
        assertEquals("First", dtoList.get(0).getFirstName());
        assertEquals("Last", dtoList.get(0).getLastName());
    }

    @Test
    void userListDTOToUserList() {
        List<UserDTO> dtoList = new ArrayList<>();
        UserDTO user = new UserDTO("1af44f5e93", "test_nick", "First", "Last");
        dtoList.add(user);

        List<User> list = userConverter.userListDTOToUserList(dtoList);

        assertEquals("test_nick", list.get(0).getNickname());
        assertEquals("First", list.get(0).getFirstName());
        assertEquals("Last", list.get(0).getLastName());
    }
}