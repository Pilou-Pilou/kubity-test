package com.test.kubity.ws;

import com.test.kubity.business.UserBusiness;
import com.test.kubity.dto.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
@Api(value = "User Controller Api")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers(){
        List<User> users = userBusiness.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", params = "userId", method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestParam(name = "userId") Integer userId){
        User user = userBusiness.getUser(userId);
        if(null != user) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/user", params = "userId", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestParam(name = "userId") Integer userId, @RequestBody User newUser){
        User user = userBusiness.updateUser(userId, newUser);
        if(null != user) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User newUser){
        userBusiness.addUser(newUser);
        return new ResponseEntity(newUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user", params = "userId", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestParam(name = "userId") Integer userId){
        userBusiness.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllUser(){
        userBusiness.deleteAllUser();
        return new ResponseEntity(HttpStatus.OK);
    }
}
