package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.UserEntity;
import util.SessionFactoryConfiguration;

public class UserRepository {

    Session session = SessionFactoryConfiguration.getInstance().getSession();

    public Integer saveUser(UserEntity entity) {
        Transaction transaction = session.beginTransaction();

        try {
            Integer id = (Integer) session.save(entity);
            transaction.commit();
            return id;
        } catch (Exception e) {
            transaction.rollback();
            return -1;
        }
    }

    public UserEntity getUser(Integer id) {
        UserEntity userEntity = session.get(UserEntity.class, id);
        return userEntity;
    }

    public UserEntity getUser(String password) {
        UserEntity userEntity = session.get(UserEntity.class, password);
        return userEntity;
    }

   public Boolean authonticationUser(UserEntity entity) {

        //Boolean bool = session.createQuery("FROM userinfo WHERE userName = :username AND password = :password", setParameter("username", entity.getUserName(), setParameter("password", entity.getPassword())));
                
        return true;

    }

    

    
}
