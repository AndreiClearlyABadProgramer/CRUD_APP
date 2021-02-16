package CRUD.service;

import CRUD.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void deleteUser(Long id);
    public void updateUser(User user);
    public List<User> userList();
    public User getUserById(long id);
}
