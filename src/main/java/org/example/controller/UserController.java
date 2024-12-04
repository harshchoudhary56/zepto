package org.example.controller;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.models.user.User;

@Data
@AllArgsConstructor
public class UserController {

    private List<User> users;

    public boolean addUser(User user) throws Exception {
        if (users.stream().noneMatch(u -> u.getId() == user.getId())) {
            users.add(user);
        } else {
            throw new Exception();
        }
        return true;
    }

    public boolean updateUser(User user) throws Exception {
        Optional<User> userToBeUpdated = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        if (userToBeUpdated.isPresent()) {
            userToBeUpdated.get().setName(user.getName());
            return true;
        } else {
            throw new Exception();
        }
    }

    public boolean deleteUser(int userId) throws Exception {
        Optional<User> userToBeDeleted = users.stream().filter(u -> u.getId() == userId).findFirst();
        if (userToBeDeleted.isPresent()) {
            users.remove(userToBeDeleted.get());
            return true;
        } else {
            throw new Exception();
        }
    }

    public User getUser(int userId) {
        Optional<User> optionalUser = users.stream().filter(user -> user.getId() == userId).findFirst();
        return optionalUser.orElse(null);
    }
}
