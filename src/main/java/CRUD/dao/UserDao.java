package CRUD.dao;

import CRUD.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(long id, User user);
    public void deleteUserById(long id);
    public List<User> userList();
}
