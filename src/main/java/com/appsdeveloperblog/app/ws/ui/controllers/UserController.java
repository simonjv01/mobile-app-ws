package com.appsdeveloperblog.app.ws.ui.controllers;


import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                  @RequestParam(value = "limit", defaultValue = "50") int limit,
                  @RequestParam(value = "sort", required = false) String sort)
    {

        return "get user was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path="/{userId}",
        produces = {
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
        })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId)
    {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Simon");
        returnValue.setLastName("Vargas");
        returnValue.setEmail("test@test.com");

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser()
    {

        return "update(put) user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {

        return "delete user was called";
    }


}
