package data.repositories;

import data.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImp implements UserRepository{
    private List<User> users = new ArrayList<>();
    private int count;

    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId()== 0;
        if(userHasNotBeenSaved) saveNew(user);
        return user;
    }

    private void saveNew(User user) {
        user.setId(generateUserId());
        users.add(user);
        count++;
    }

    private int generateUserId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for(var user: users) if(user.getId() == id) return user;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        users.removeIf(use -> use == user);
        count--;
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
        count--;
    }

    @Override
    public void deleteAll() {
        users.clear();
        count=0;
    }

    @Override
    public User findByUsername(String eMailAddress) {
        for(var user: users) if(Objects.equals(user.getEmailAddress(), eMailAddress)) return user;

        return null;
    }
}
