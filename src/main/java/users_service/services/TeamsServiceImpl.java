package users_service.services;

import users_service.converters.TeamConverter;
import users_service.dao.TeamsDAOImpl;
import users_service.dto.TeamDTO;
import users_service.entity.Team;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "users_service.services.TeamsService")
public class TeamsServiceImpl implements TeamsService {

    private final TeamsDAOImpl teamsDAO = new TeamsDAOImpl();
    private final TeamConverter teamConverter = new TeamConverter();

    @Override
    public TeamDTO addTeam(String teamName, String color) {
        Team team = teamsDAO.create(new Team(teamName, color));
        return teamConverter.teamToTeamDTO(team);
    }

    @Override
    public TeamDTO getTeam(long teamId) {
        Team team = teamsDAO.getById(teamId);
        return teamConverter.teamToTeamDTO(team);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamsDAO.getAll();
        return teamConverter.teamListToDTOTeamList(teams);
    }

    @Override
    public void updateTeam(TeamDTO teamDTO) {
        Team team = teamConverter.teamDTOToTeam(teamDTO);
        teamsDAO.update(team);
    }

    @Override
    public void deleteTeamById(long teamId) {
        Team team = teamsDAO.getById(teamId);
        teamsDAO.delete(team);
    }
}
