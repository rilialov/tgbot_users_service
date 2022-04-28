package users_service.services;

import users_service.dto.TeamDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamService {

    @WebMethod
    boolean addTeam(String teamName, String color);

    @WebMethod
    TeamDTO getTeam(int teamId);

    @WebMethod
    List<TeamDTO> getAllTeams();

    @WebMethod
    boolean updateTeam(TeamDTO teamDTO);

    @WebMethod
    boolean deleteTeamById(int teamId);
}
