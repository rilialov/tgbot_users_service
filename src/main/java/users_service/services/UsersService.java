package users_service.services;

import users_service.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UsersService {

    @WebMethod
    UserDTO addUser(String chatId, String nickname, String firstName, String lastName);

    @WebMethod
    UserDTO getUserById(String chatId);

    @WebMethod
    UserDTO getUserByNick(String nickname);

    @WebMethod
    List<UserDTO> getAllUsers();

    @WebMethod
    void updateUser(UserDTO userDTO);

    @WebMethod
    void deleteUserById(String chatId);
}
