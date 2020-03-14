package spring.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.database.dao.UserRepository;
import spring.database.model.User;

import java.lang.annotation.Documented;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @Created 12 / 03 / 2020 - 10:19 AM
 * @project database
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("/users")
public class UserController {
    //

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main")
    public String test(){
        String testing = "testing";
        return testing;
    }

    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userRepository.getUsers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser (@PathVariable("id") Integer id) {
        User user = userRepository.findById(id);
        if(user == null) {
            return new ResponseEntity<String>("No User found with this : " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        if(userRepository.findById(user.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry: " + user.getId(), HttpStatus.IM_USED);
        }
        userRepository.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        if (userRepository.findById(user.getId())==null) {
            return new ResponseEntity<String>("Unable to update as User id" + user.getId() + "not found.", HttpStatus.NOT_FOUND);
        }

        userRepository.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * Deletes user by id
     * @param id user's id where is being deleted
     * @return ResponseEntity deleted user entity
     * */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id);
        if(user==null){
            return new ResponseEntity<String>("Unable to delete as User id" + id + "not found.", HttpStatus.NOT_FOUND);
        }

        userRepository.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
