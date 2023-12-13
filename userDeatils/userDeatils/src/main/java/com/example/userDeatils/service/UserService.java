package com.example.userDeatils.service;

import com.example.userDeatils.dto.UesrDtoPojo;
import com.example.userDeatils.dto.UserDTO;

public interface UserService {
   // UesrDtoPojo postUser(Integer id, String name);
    UserDTO postUser(UserDTO  userDTO);

    UserDTO getUser(Integer id);

    UserDTO updateUser(UserDTO userDTO);
}
