package users_service.converters;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import users_service.dto.UserDTO;
import users_service.entity.User;

import java.util.List;

public class UserConverter {
    private final ModelMapper modelMapper;

    public UserConverter() {
        modelMapper = new ModelMapper();
    }

    public UserDTO userToUserDTO (User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User userDTOToUser (UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public List<UserDTO> userListToDTOUserList(List<User> userList) {
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public List<User> userListDTOToUserList(List<UserDTO> userDTOList) {
        return modelMapper.map(userDTOList, new TypeToken<List<User>>() {}.getType());
    }
}
