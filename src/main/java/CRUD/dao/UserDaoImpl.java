package CRUD.dao;

import CRUD.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> userList() {
        try {
            List<User> users = entityManager.createQuery("select user from User user").getResultList();
            return users;
        }catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
