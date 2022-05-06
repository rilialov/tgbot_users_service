package users_service.services;

import users_service.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UsersService {

    @WebMethod
    UserDTO addUser(long chatId, String firstName);

    @WebMethod
    UserDTO getUserById(long chatId);

    @WebMethod
    UserDTO getUserByNick(String nickname);

    @WebMethod
    List<UserDTO> getAllUsers();

    @WebMethod
    void updateUser(UserDTO userDTO);

    @WebMethod
    void deleteUserById(long chatId);
}
