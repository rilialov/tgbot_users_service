package users_service.dao;

public interface UsersDAO <T> extends DAO<T> {
    T getByChatId(long chatId);
    T getByNickname(String nickname);
}
