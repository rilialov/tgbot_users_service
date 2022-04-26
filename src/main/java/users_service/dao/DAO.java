package users_service.dao;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();

    T create(T t);

    T update(T t);

    void delete(T t);
}
