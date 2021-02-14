package CRUD.dao;

import CRUD.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User user) {
        User user1 = user;
        user1.setId(id);
        entityManager.merge(user1);
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> userList() {
        List<User> users;
        users = entityManager.createQuery("select id, name, lastName, age from User").getResultList();
        return users;
    }
}
