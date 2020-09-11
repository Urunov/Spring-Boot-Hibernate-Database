package com.urunov.resources;

import com.urunov.model.User;
import com.urunov.model.UserContact;
import com.urunov.model.UserLog;
import com.urunov.repository.UserContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate
 */
@RequestMapping
public class UserContactResource {

    private UserContactRepository userContactRepository;

    public UserContactResource(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @GetMapping(value = "/all")
    public List<UserContact> getUserContact(){
        return userContactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<UserContact> update(@PathVariable final String name){

        UserContact userContact = new UserContact();
        User user = new User();

        UserLog userLog = new UserLog();
        userLog.setLog("Hi my youtube friends");

        UserLog userLog1 = new UserLog();
        userLog1.setLog("Hi Viewers");

        user.setTeamName("Develeopers")
                .setSalary(10000)
                .setName(name)
                .setUserLogs(Arrays.asList(userLog, userLog1));

        userContact.setPhoneNo(2323).setUser(user);

        // persist
        userContactRepository.save(userContact);

        //getall
        return userContactRepository.findAll();

    }
}
