package com.fitapp.services;


import com.fitapp.dto.LoginRequest;
import com.fitapp.dto.RegisterRequest;
import com.fitapp.entity.User;
import com.fitapp.exceptions.ResourceNotFoundException;
import com.fitapp.repository.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtService jwtService;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest registerRequest){
        if(userRepo.existsByUsername(registerRequest.getUsername())){
            throw new ResourceNotFoundException("Uzivatel s takymto menom uz existuje");
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepo.save(user);
        return "Uspesne zaregistrovany";
    }

    public String loginUser(LoginRequest loginRequest){
        User user = userRepo.findByUsername(loginRequest.getUsername()).orElseThrow(()-> new RuntimeException("Nespravne meno alebo heslo"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new ResourceNotFoundException("Nespravne meno alebo heslo");
        }
        return jwtService.generateToken(user.getUsername());
    }

}
