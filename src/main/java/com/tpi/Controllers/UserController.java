package com.tpi.Controllers;


import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.User;
import com.tpi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/listall")
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.ListAllUsers());
    }
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.SaveUser(user));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.FindUserByID(id));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) throws BadRequestException {
        userService.DeleteByID(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
