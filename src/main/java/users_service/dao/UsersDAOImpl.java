package users_service.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import users_service.entity.User;
import users_service.util.HibernateSessionFactoryUtil;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsersDAOImpl implements UsersDAO<User> {

    @Override
    public User getByChatId(long chatId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, chatId);
    }

    @Override
    public User getByNickname(String nickname) {
        CriteriaBuilder cb = HibernateSessionFactoryUtil.getSessionFactory().openSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.select(user).where(user.get("nickname").in(nickname));
        TypedQuery<User> tq = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(cq);
        try {
            return tq.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From User").list();
    }

    @Override
    public User create(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return user;
    }

    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
