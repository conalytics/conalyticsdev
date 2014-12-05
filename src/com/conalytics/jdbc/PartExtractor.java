package com.conalytics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.conalytics.domain.Part;

public class PartExtractor implements ResultSetExtractor<Part> {

	public Part extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {

		Part part = new Part();
		part.setPartId(resultSet.getDouble(1));
		part.setAutoId(resultSet.getDouble(2));
		part.setPartName(resultSet.getString(3));
		part.setPartDesc(resultSet.getString(4));
		part.setModel(resultSet.getString(5));
		part.setVersion(resultSet.getString(6));
		part.setYearBuilt(resultSet.getDouble(7));
		part.setOemNumber(resultSet.getString(8));
		part.setColor(resultSet.getString(9));
		part.setMsrp(resultSet.getDouble(10));
		part.setCategoryId(resultSet.getDouble(11));
		if(resultSet.getMetaData().getColumnCount() > 11) {
			part.setCategoryName(resultSet.getString(12));
		}
		return part;
	}
}
