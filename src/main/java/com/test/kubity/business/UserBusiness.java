package com.test.kubity.business;


import com.test.kubity.dao.UserDao;
import com.test.kubity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserBusiness {

    @Autowired
    UserDao userDao;

    /**
     * Add user in the db
     *
     * @param user : user to save in the db
     */
    public void addUser(User user){

        // Call an other api for retrieve data to add to the object user
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            Object response = restTemplate.exchange("https://api.chucknorris.io/jokes/random", HttpMethod.GET, entity, Object.class);

            String quoteChuckNorris = ((Map<String, String>) ((ResponseEntity) response).getBody()).get("value");
            user.setQuote(quoteChuckNorris.substring(0,Math.min(quoteChuckNorris.length(),255)));
        } catch (Exception e){

        }

        userDao.addUser(user);
    }

    /**
     * Get a specific user
     *
     * @param userId : Id of the user research
     *
     * @return the user find
     */
    public User getUser(Integer userId){
        User user = userDao.getUser(userId);
        return user;
    }

    /**
     * Get all users present in the db
     *
     * @return the list of all user save in the db
     */
    public List<User> getUsers(){
        List<User> users = userDao.getUsers();
        return users;
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
        User user = userDao.updateUser(oldUserId, newUser);
        return user;
    }

    /**
     * Delete a specific user
     *
     * @param userId : Id of user to delete
     */
    public void deleteUser(Integer userId){
        userDao.deleteUser(userId);
    }

    /**
     * Delete all users
     */
    public void deleteAllUser(){
        userDao.deleteAllUsers();
    }
}
