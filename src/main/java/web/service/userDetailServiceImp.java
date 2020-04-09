package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import web.dao.UserDAO;
import web.model.User;

public class userDetailServiceImp implements UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public void UserDetailServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.getUserByLogin(s);
        if (user != null) {
            return user;
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
