package CRUD.dao;

import CRUD.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User user) {
        User newUser = getUserById(id);
        newUser.setName(user.getName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
        entityManager.merge(newUser);
    }

    @Override
    @Transactional
    public List<User> userList() {
        try {
            List<User> users = entityManager.createQuery("select user from User user").getResultList();
            return users;
        }catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
