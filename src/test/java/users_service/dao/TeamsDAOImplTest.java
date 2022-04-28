package users_service.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_service.entity.Team;

import java.util.List;

class TeamsDAOImplTest {

    private TeamsDAOImpl teamsDAO;

    @BeforeEach
    void init() {
        teamsDAO = new TeamsDAOImpl();
    }

    @Test
    void getById() {
        Team team = teamsDAO.getById(1L);

        Assertions.assertNotNull(team);
    }

    @Test
    void getAll() {
        List<Team> teams = teamsDAO.getAll();

        Assertions.assertNotNull(teams);
        Assertions.assertTrue(teams.size() > 0);
    }

    @Test
    void create() {
        Team team = new Team("Team Name", "Team Color");
        Team created = teamsDAO.create(team);

        teamsDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        Team team = new Team("Team Name", "Team Color");
        Team created = teamsDAO.create(team);

        created.setTeamName("Changed Name");
        created.setColor("Changed Color");
        teamsDAO.update(created);

        Team updated = teamsDAO.getById(created.getId());
        teamsDAO.delete(updated);
        Assertions.assertEquals("Changed Name", updated.getTeamName());
        Assertions.assertEquals("Changed Color", updated.getColor());
    }

    @Test
    void delete() {
        Team team = new Team("Team Name", "Team Color");
        Team created = teamsDAO.create(team);

        teamsDAO.delete(created);

        Team deleted = teamsDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}