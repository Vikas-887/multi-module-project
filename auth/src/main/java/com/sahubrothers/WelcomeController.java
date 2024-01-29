package com.sahubrothers;


import com.sahubrothers.entity.AuthRequest;
import com.sahubrothers.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping( "/" )
    public String welcome() {
        return "Welcome to sahubrothers !!";
    }

    @PostMapping( "/authenticate" )
    public String generateToken( @RequestBody AuthRequest authRequest ) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( authRequest.getUserName(), authRequest.getPassword() )
            );
        } catch ( Exception ex ) {
            throw new Exception( "inavalid username/password" );
        }
        return jwtUtil.generateToken( authRequest.getUserName() );
    }

    @GetMapping( "/api/v1/create" )
    public String myresponse() {
        return "hello World";
    }
}
