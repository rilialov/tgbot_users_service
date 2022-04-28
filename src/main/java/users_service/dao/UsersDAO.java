package users_service.dao;

public interface UsersDAO <T> extends DAO<T> {
    T getByChatId(String chatId);
    T getByNickname(String nickname);
}
