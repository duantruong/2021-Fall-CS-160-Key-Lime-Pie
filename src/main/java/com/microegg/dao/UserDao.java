package com.microegg.dao;

import com.microegg.dao.mapper.AddressMapper;
import com.microegg.dao.mapper.CardMapper;
import com.microegg.model.Address;
import com.microegg.model.Card;
import com.microegg.model.Login;
import com.microegg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public User addUser(User user){
        String query = "INSERT INTO USERS (fname,lname,gender,mobile) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,user.getFname(),user.getLname(),user.getGender(),user.getMobile());
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(id);
        return user;
    }

    public User getUser(int userId){
        String query = "SELECT * FROM USERS WHERE userId="+ userId;
        User user = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public int addLoginCredentials(Login login){
        String query = "INSERT INTO Login_Credentials (emailId,password,userId) VALUES(?,?,?)";
        return jdbcTemplate.update(query,login.getEmailId(),login.getPassword(), login.getUserId());
    }

    public int deleteUser(int userId){
        String query = "delete from users where userId="+userId;
        return jdbcTemplate.update(query);
    }

    public Login doLogin(String emailId, String password){
        String query = "SELECT * FROM Login_Credentials WHERE emailId ='" + emailId + "'";
        Login user = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Login.class));
        if(user.getPassword().equals(password)) return user;
        return null;
    }

    public Address addAddress(Address address){
        String query = "INSERT INTO address (buildingNo,street1,street2,city,province,zip,userId) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,address.getBuildingNo(),address.getStreet1(),address.getStreet2(),address.getCity(),address.getProvince()
        ,address.getZip(),address.getUserId());
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        address.setAddressId(id);
        return address;
    }

    public List<Address> getAllAddressByUserId(Integer userId){
        String query = "Select * from address where userId =" + userId;
        return jdbcTemplate.query(query, new AddressMapper());
    }

    public Card addCard(Card card){
        String query = "INSERT INTO CARDS (cardHolderName,cardNumber,expirationDate,userId) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,card.getCardHolderName(),card.getCardNumber(),card.getExiprationDate(),card.getUserId());
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        card.setCardId(id);
        return card;
    }

    public List<Card> getCards(Integer userId){
        String query = "Select * from cards where userId =" + userId;
        return jdbcTemplate.query(query, new CardMapper());
    }








}
