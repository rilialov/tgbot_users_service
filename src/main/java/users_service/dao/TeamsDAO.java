package users_service.dao;

public interface TeamsDAO <T> extends DAO<T> {
    T getById(Long id);
}
