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
    public UserDTO addUser(String chatId, String nickname, String firstName, String lastName) {
        User user = usersDAO.create(new User(chatId, nickname, firstName, lastName));
        return userConverter.userToUserDTO(user);
    }

    @Override
    public UserDTO getUserById(String chatId) {
        User user = usersDAO.getByChatId(chatId);
        return userConverter.userToUserDTO(user);
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
    public void deleteUserById(String chatId) {
        User user = usersDAO.getByChatId(chatId);
        usersDAO.delete(user);
    }
}
