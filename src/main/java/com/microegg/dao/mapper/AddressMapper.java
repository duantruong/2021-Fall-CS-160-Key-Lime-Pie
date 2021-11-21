package com.microegg.dao.mapper;


import com.microegg.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setAddressId(rs.getInt("addressId"));
        address.setBuildingNo(rs.getString("buildingNo"));
        address.setStreet1(rs.getString("street1"));
        address.setStreet2(rs.getString("street2"));
        address.setCity(rs.getString("city"));
        address.setProvince(rs.getString("province"));
        address.setZip(rs.getInt("zip"));
        address.setUserId(rs.getInt("userId"));

        return address;

    }
}
