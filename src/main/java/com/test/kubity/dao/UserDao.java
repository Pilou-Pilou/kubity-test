package com.test.kubity.dao;

import com.test.kubity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    DataBase database;

    /**
     * Add user in the db
     *
     * @param user : user to save in the db
     */
    public void addUser(User user){
        database.save(user);
    }

    /**
     * Get all users present in the db
     *
     * @return the list of all user save in the db
     */
    public List<User> getUsers(){
        List<User> users = database.findAll();
        return users;
    }

    /**
     * Get a specific user
     *
     * @param userId : Id of the user research
     *
     * @return the user find
     */
    public User getUser(Integer userId){
        User user = database.findOne(userId);
        return user;
    }

    /**
     * Update the value of an user in the db
     *
     * @param oldUserId : id of the user to update
     * @param newUser : new value of the object user
     *
     * @return the user with the new value
     */
    public User updateUser(Integer oldUserId, User newUser){

        User user = null;

        if(database.exists(oldUserId)) {
            user = database.findOne(oldUserId);
            user.setName(newUser.getName());
            user.setCountry(newUser.getCountry());
            database.saveAndFlush(user);
        }

        return user;
    }

    /**
     * Delete a specific user
     *
     * @param userId : Id of user to delete
     */
    public void deleteUser(Integer userId){
        database.delete(userId);
    }

    /**
     * Delete all users
     */
    public void deleteAllUsers(){
        database.deleteAll();
    }
}
