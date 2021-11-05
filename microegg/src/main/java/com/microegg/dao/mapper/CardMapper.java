package com.microegg.dao.mapper;

import com.microegg.model.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new Card();
        card.setCardId(rs.getInt("cardId"));
        card.setCardNumber(rs.getInt("cardNumber"));
        card.setCardHolderName(rs.getString("cardHolderName"));
        card.setExiprationDate(rs.getDate("expirationDate"));
        return card;
    }
}
