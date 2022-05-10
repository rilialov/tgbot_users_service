package users_service.services;

import users_service.converters.UserConverter;
import users_service.dao.UsersDAOImpl;
import users_service.dto.UserDTO;
import users_service.entity.User;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "users_service.services.UsersService")
public class UsersServiceImpl implements UsersService {

    private final UsersDAOImpl usersDAO = new UsersDAOImpl();
    private final UserConverter userConverter = new UserConverter();

    @Override
    public UserDTO addUser(long chatId, String firstName) {
        User user = usersDAO.create(new User(chatId, firstName));
        return userConverter.userToUserDTO(user);
    }

    @Override
    public UserDTO getUserById(long chatId) {
        User user = usersDAO.getByChatId(chatId);
        if (user == null) {
            return new UserDTO();
        } else return userConverter.userToUserDTO(user);
    }

    @Override
    public UserDTO getUserByNick(String nickname) {
        User user = usersDAO.getByNickname(nickname);
        return userConverter.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = usersDAO.getAll();
        return userConverter.userListToDTOUserList(users);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userConverter.userDTOToUser(userDTO);
        usersDAO.update(user);
    }

    @Override
    public void deleteUserById(long chatId) {
        User user = usersDAO.getByChatId(chatId);
        usersDAO.delete(user);
    }
}
