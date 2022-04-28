package users_service.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_service.entity.Role;
import users_service.entity.User;

import java.util.List;

class UsersDAOImplTest {

    private UsersDAOImpl usersDAO;

    @BeforeEach
    void init() {
        usersDAO = new UsersDAOImpl();
    }

    @Test
    void getByChatId() {
        User user = usersDAO.getByChatId("fdd1135e8d");

        Assertions.assertNotNull(user);
    }

    @Test
    void getByNickname() {
        User user = usersDAO.getByNickname("ultricies");

        Assertions.assertNotNull(user);
    }

    @Test
    void getAll() {
        List<User> users = usersDAO.getAll();

        Assertions.assertNotNull(users);
        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    void create() {
        User user = new User("1af44f5e93", "Nickname", "Name",
                "Last Name");
        user.setRole(Role.STUDENT);
        User created = usersDAO.create(user);

        usersDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        User user = new User("1af44f5e93", "Nickname", "Name",
                "Last Name");
        user.setRole(Role.STUDENT);
        User created = usersDAO.create(user);

        created.setFirstName("Changed Name");
        created.setLastName("Changed Last Name");
        created.setNickname("Changed Nickname");

        usersDAO.update(created);

        User updated = usersDAO.getByChatId(created.getChatId());
        usersDAO.delete(updated);
        Assertions.assertEquals("Changed Name", updated.getFirstName());
        Assertions.assertEquals("Changed Last Name", updated.getLastName());
        Assertions.assertEquals("Changed Nickname", updated.getNickname());
    }

    @Test
    void delete() {
        User user = new User("1af44f5e93", "Nickname", "Name",
                "Last Name");
        user.setRole(Role.STUDENT);
        User created = usersDAO.create(user);

        usersDAO.delete(created);

        User deleted = usersDAO.getByChatId(created.getChatId());
        Assertions.assertNull(deleted);
    }
}