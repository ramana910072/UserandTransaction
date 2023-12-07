package com.example.userDeatils.controller;

import com.example.userDeatils.dto.UesrDtoPojo;
import com.example.userDeatils.dto.UserDTO;
import com.example.userDeatils.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Post Data to the Transaction")
    @ApiResponse(responseCode = "200",description = "List of Transactions added")
    @ApiResponse(responseCode = "204",description = "Transactions not added")
    @PostMapping("/post")
    public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.postUser(userDTO), HttpStatus.OK);
    }
    @Operation(summary = "Post Data to the Transaction")
    @ApiResponse(responseCode = "200",description = "List of Transactions added")
    @ApiResponse(responseCode = "204",description = "Transactions not added")
    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId){

        return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
    }
    @Operation(summary = "Post Data to the Transaction")
    @ApiResponse(responseCode = "200",description = "List of Transactions added")
    @ApiResponse(responseCode = "204",description = "Transactions not added")
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.updateUser(userDTO),HttpStatus.OK);
    }

}
