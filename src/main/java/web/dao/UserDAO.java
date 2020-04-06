package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> listAllUsers();
    User getUserById(long id);
}
