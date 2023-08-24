package com.chat.server.auth;

import com.chat.server.model.User;
import com.chat.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;



@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String reg(User regUser){
        if(userRepository.findUserByName(regUser.getName()).isEmpty()){
            userRepository.save(regUser);
            return "OK";
        }
        return "name taken";
    }


    public String login (User loginUser){
        Optional<User> user = userRepository.findUserByName(loginUser.getName());
        if(user.isEmpty())
            return "wrong username";
        else{
            if (user.get().getPassword().equals(loginUser.getPassword()))
                return "OK";
            return "wrong password";
        }
    }
}
