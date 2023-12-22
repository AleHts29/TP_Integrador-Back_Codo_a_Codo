package com.tpi.Service;


import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.User;
import com.tpi.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User SaveUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }
        return userRepository.save(user);
    }

    public List<User> ListAllUsers(){
        return userRepository.findAll();
    }


    public User FindUserByID(Long id) throws BadRequestException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return userRepository.findById(id).get();
        }else{
            throw new BadRequestException("This user doesn't exist");
        }
    }

    public void DeleteByID(Long id) throws BadRequestException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new BadRequestException("This user can't be deleted since it doesn't exist");
        }
    }
}
