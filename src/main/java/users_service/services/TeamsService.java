package users_service.services;

import users_service.dto.TeamDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamsService {

    @WebMethod
    TeamDTO addTeam(String teamName, String color);

    @WebMethod
    TeamDTO getTeam(long teamId);

    @WebMethod
    List<TeamDTO> getAllTeams();

    @WebMethod
    void updateTeam(TeamDTO teamDTO);

    @WebMethod
    void deleteTeamById(long teamId);
}
