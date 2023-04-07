package com.group02.mobileshopsystem.api.Controller;

import com.group02.mobileshopsystem.api.Payload.Request.AuthenticationRequest;
import com.group02.mobileshopsystem.api.Payload.Request.RegisterRequest;
import com.group02.mobileshopsystem.api.Payload.Response.AuthenticationResponse;
import com.group02.mobileshopsystem.api.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

@Autowired
  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authenticationService.register(request));
  }
  @PostMapping("/registerAdmin")
  public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authenticationService.registerAdmin(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

  @GetMapping(path = "/confirm")
  public String confirm(@RequestParam("token") String token) {
    return authenticationService.confirmToken(token);
  }
}
