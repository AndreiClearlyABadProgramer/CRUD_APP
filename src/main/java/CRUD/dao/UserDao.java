package CRUD.dao;

import CRUD.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(long id);
    public void updateUser(User user);
    public List<User> userList();
    public User getUserById(long id);
}
