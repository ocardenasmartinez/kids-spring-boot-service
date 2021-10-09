package cl.kids.controllers;

import cl.kids.entities.request.AuthenticationRequest;
import cl.kids.entities.request.AuthenticationResponse;
import cl.kids.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtTokenUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAutenticationToken(@RequestBody AuthenticationRequest athenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(athenticationRequest.getUsername(), athenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(athenticationRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwtTokenUtils.generateToken(userDetails)));
    }

}
