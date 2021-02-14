package CRUD.service;

import CRUD.dao.UserDao;
import CRUD.dao.UserDaoImpl;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ServiceImpl implements Service{

    @Autowired
    private UserDao userDao = new UserDaoImpl();

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> userList() {
        return userDao.userList();
    }
}
