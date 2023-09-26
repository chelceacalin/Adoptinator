package ro.adoptinator.Adoptinator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.adoptinator.Adoptinator.dto.UserRequestDTO;
import ro.adoptinator.Adoptinator.dto.UserResponseDTO;
import ro.adoptinator.Adoptinator.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.addUser(userRequestDTO), HttpStatus.CREATED);
    }
}
