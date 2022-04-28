package users_service.services;

import users_service.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    @WebMethod
    boolean addUser(long chatId, String nickname, String firstName, String lastName);

    @WebMethod
    UserDTO getUserById(long chatId);

    @WebMethod
    UserDTO getUser(String nickname);

    @WebMethod
    List<UserDTO> getAllUsers();

    @WebMethod
    boolean updateUser(UserDTO userDTO);

    @WebMethod
    boolean deleteUserById(long chatId);
}
