package com.nghiasoftware.demojpa08.services;

import com.nghiasoftware.demojpa08.dto.RoleDTO;
import com.nghiasoftware.demojpa08.dto.UserDTO;
import com.nghiasoftware.demojpa08.entity.Users;
import com.nghiasoftware.demojpa08.entity.UsersRoles;
import com.nghiasoftware.demojpa08.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements UserServiceImp {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> listUser = usersRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users user : listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getUsername());

            List<RoleDTO> roleDTOList = new ArrayList<>();
            for(UsersRoles usersRoles : user.getUsersRoles()) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setId(usersRoles.getRoles().getId());
                roleDTO.setName(usersRoles.getRoles().getName());

                roleDTOList.add(roleDTO);
            }

            userDTO.setRoles(roleDTOList);

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
