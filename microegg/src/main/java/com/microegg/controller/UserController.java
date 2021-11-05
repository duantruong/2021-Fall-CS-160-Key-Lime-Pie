package com.microegg.controller;

import com.microegg.model.Address;
import com.microegg.model.Card;
import com.microegg.model.Login;
import com.microegg.model.User;
import com.microegg.response.ApiRestResponse;
import com.microegg.service.UserService;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiRestResponse>  addUser(@RequestBody User user){
        ApiRestResponse response = new ApiRestResponse();
        try {
            User addedUser = userService.addUser(user);
            Login login = new Login();
            login.setUserId(addedUser.getUserId());
            login.setEmailId(addedUser.getEmailId());
            login.setPassword(user.getPassword());
            userService.addLoginCredentials(login);
            response.setData(user);
        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiRestResponse> getUser(@PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            User user = userService.getUser(userId);
            response.setData(user);
        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);


    }

    @PostMapping("/login")
    public ResponseEntity<ApiRestResponse> loginUser(@RequestBody Login login) {
        ApiRestResponse response = new ApiRestResponse();
        try {
            Login loginUser = userService.doLogin(login.getEmailId(), login.getPassword());
            response.setData(loginUser.getUserId());
        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }

        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

    }

    @PostMapping("/addAddress/{userId}")
    public  ResponseEntity<ApiRestResponse> addAddress(@RequestBody Address address, @PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try {
            address.setUserId(userId);
            Address address1 = userService.addAddress(address);
            response.setData(address1);

        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }


    @GetMapping("/getAllAddress/{userId}")
    public ResponseEntity<ApiRestResponse> getAllAddressbyUserId(@PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try {

            List<Address> addresss = userService.getAllAddressByUserId(userId);
            response.setData(addresss);

        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }


    @PostMapping("/addCard/{userId}")
    public  ResponseEntity<ApiRestResponse> addCard(@RequestBody Card card, @PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try {
            card.setUserId(userId);
            Card card1 = userService.addCard(card);
            response.setData(card1);

        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }


    @GetMapping("/getAllCards/{userId}")
    public ResponseEntity<ApiRestResponse> getAllCards(@PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try {
            List<Card> card = userService.getCards(userId);
            response.setData(card);
        }catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }
}
