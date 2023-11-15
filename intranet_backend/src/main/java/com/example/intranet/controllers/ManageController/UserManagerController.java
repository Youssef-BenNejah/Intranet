package com.example.intranet.controllers.ManageController;

import com.example.intranet.Dto.UserDto;
import com.example.intranet.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Usermanage")
@PreAuthorize("hasRole('ADMIN')")
public class UserManagerController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('admin_create')")
    @PostMapping("/addUser")
    public ResponseEntity <ErrorResponse> addUser(@RequestBody @Valid UserDto userDto ,
                                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> error = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            ErrorResponse errorResponse = new ErrorResponse("Validation error",error);
            return ResponseEntity.badRequest().body(errorResponse);
        }
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('admin_read')")
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);

    }
    @PreAuthorize("hasAuthority('admin_read')")
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id){
        if (!userService.existById(id))
        {
            return ResponseEntity.notFound().build();
        }
        UserDto userDto = userService.GetUserById(id);
        return ResponseEntity.ok(userDto);

    }
    @PreAuthorize("hasAuthority('admin_update')")
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ErrorResponse> updateUser(@RequestBody @Valid UserDto userDto,@PathVariable long id,
                                              BindingResult bindingResult){
        if ( bindingResult.hasErrors())
        {
           List<String> error = bindingResult.getAllErrors().stream()
                   .map(ObjectError::getDefaultMessage)
                   .collect(Collectors.toList());
           ErrorResponse errorResponse = new ErrorResponse("validation error",error);
           return ResponseEntity.badRequest().body(errorResponse);
        }
        userService.updateUser(id, userDto);
        return ResponseEntity.ok().build();

    }
    @PreAuthorize("hasAuthority('admin_delete')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteUSer(@PathVariable long id){
        if (!userService.existById(id))
        {
            return ResponseEntity.notFound().build();
        }
        userService.deleteClient(id);
        return ResponseEntity.ok("user deleted");

    }
}
