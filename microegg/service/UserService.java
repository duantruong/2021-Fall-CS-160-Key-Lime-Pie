package com.microegg.service;

import com.microegg.dao.UserDao;
import com.microegg.dao.mapper.AddressMapper;
import com.microegg.dao.mapper.CardMapper;
import com.microegg.model.Address;
import com.microegg.model.Card;
import com.microegg.model.Login;
import com.microegg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserService {

    @Autowired
    private UserDao userDao;

    public User addUser(User user){
        return userDao.addUser(user);
    }

    public User getUser(int userId){
        return userDao.getUser(userId);
    }

    public int addLoginCredentials(Login login){
        return userDao.addLoginCredentials(login);
    }

    public Login doLogin(String emailId, String password){
        Login login = userDao.doLogin(emailId,password);
        if(login == null) throw new RuntimeException("Invalid User crednetials");
        return login;
    }

    public Address addAddress(Address address){
       return userDao.addAddress(address);
    }

    public List<Address> getAllAddressByUserId(Integer userId){
        return userDao.getAllAddressByUserId(userId);
    }

    public Card addCard(Card card){
        return userDao.addCard(card);
    }

    public List<Card> getCards(Integer userId){
        return userDao.getCards(userId);
    }
}
