package com.conalytics.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



















import com.conalytics.domain.Inventory;
import com.conalytics.domain.Part;
import com.conalytics.domain.Shop;
import com.conalytics.jdbc.InventoryRowMapper;
import com.conalytics.jdbc.PartRowMapper;


public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void insertData(Inventory invent) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO SHOP_PARTS_INFO (SHOP_PART_ID, SHOP_ID, PART_ID, QTY_AVAILABLE, PRICE_PER_UNIT, RTL_PRICE_PER_UNIT, STD_HRLY_PART_LABOR_RATE) "
				+ "VALUES  (?, ?, ?, ?, ?, ? ,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						invent.getSHOP_PART_ID(),
						invent.getSHOP_ID(),
						invent.getPART_ID(),
						invent.getQTY_AVAILABLE(),
						invent.getPRICE_PER_UNIT(),
						invent.getRTL_PRICE_PER_UNIT(),
						invent.getSTD_HRLY_PART_LABOR_RATE()
							});
	}

	@Override
	public void updateData(Inventory invent) {
		// TODO Auto-generated method stub
		

		String sql = "UPDATE SHOP_PARTS_INFO set SHOP_ID=?, PART_ID=?, QTY_AVAILABLE=?, PRICE_PER_UNIT=?, RTL_PRICE_PER_UNIT=?, STD_HRLY_PART_LABOR_RATE=? where SHOP_PART_ID = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { 
						invent.getSHOP_ID(),
						invent.getPART_ID(),
						invent.getQTY_AVAILABLE(),
						invent.getPRICE_PER_UNIT(),
						invent.getRTL_PRICE_PER_UNIT(),
						invent.getSTD_HRLY_PART_LABOR_RATE(),
						invent.getSHOP_PART_ID()
							});
    
	}

	@Override
	public void deleteData(Double id) {
		// TODO Auto-generated method stub
		String sql = "delete from SHOP_PARTS_INFO where SHOP_PART_ID=" + id.doubleValue();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Inventory> getInventorybyPartId(Double partId) {
		// TODO Auto-generated method stub
		List<Inventory> invList = new ArrayList<Inventory>();
		String sql = "select * , null from SHOP_PARTS_INFO where PART_ID= " + partId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		invList = jdbcTemplate.query(sql, new InventoryRowMapper());
		return invList;
		
		}

	
	@Override
	public List<Inventory> getInventorybyShopList(List<Shop> shopl,Double partId) {
		// TODO Auto-generated method stub
		String inClause="";
		for (int i = 0; i < shopl.size(); i++) {
			Shop s=shopl.get(i);
			if(i ==0)
			{
				inClause=s.getShopId().toString();
			}
			else
			{
			inClause = inClause +","+s.getShopId();
		    }
			
		}
			inClause =" IN ("+inClause+")";
			
			String sql ="select * from SHOP_PARTS_INFO where PART_ID= " + partId +" and SHOP_ID "+inClause;
            System.out.println(sql);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Inventory> invList = new ArrayList<Inventory>();
			invList = jdbcTemplate.query(sql, new InventoryRowMapper());
			return invList;
	       }

	@Override
	public Inventory getInventorybyShopandPartId(Double shopId, Double partId) {
		// TODO Auto-generated method stub
		String sql ="select * from SHOP_PARTS_INFO where PART_ID= " + partId +" and SHOP_ID ="+shopId;
        System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Inventory> invList = new ArrayList<Inventory>();
		invList = jdbcTemplate.query(sql, new InventoryRowMapper());
		return invList.get(0);
	}

	@Override
	public byte[] getImagebyInvId(Double invId){
		// TODO Auto-generated method stub
		String sql ="select * from SHOP_PARTS_INFO where SHOP_PART_ID = " + invId; 
        System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Inventory> invList = new ArrayList<Inventory>();
		invList = jdbcTemplate.query(sql, new InventoryRowMapper());
		
		byte[] imgData =null;
		try {
			Blob img =invList.get(0).getImage();
			imgData = img.getBytes(1,(int)img.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imgData;
		
	}
	

	
	@Override
	public List<Inventory> getShopPartsdata()
	{
		// TODO Auto-generated method stub
		String sql ="select * from SHOP_PARTS_INFO"; 
        System.out.println(sql);
        System.out.println(sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Inventory> invList = new ArrayList<Inventory>();
		invList = jdbcTemplate.query(sql, new InventoryRowMapper());
		return invList;		
	
	}

	@Override
	public List<Inventory> getInventorybyShopListandPartDesc(List<Shop> shopl,String pdesc) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//parse pdesc
		 StringTokenizer st = new StringTokenizer(pdesc);
		 List<Inventory> masterList=null;
		 String sql = "";
		 while(st.hasMoreTokens())
		 {
			 String token = st.nextToken(" ");
		 		if (! token.equalsIgnoreCase("the") || !token.equalsIgnoreCase("and") || !token.equalsIgnoreCase("it") || !token.equalsIgnoreCase("of"))
	 			{
		
		 			String temp="select * from PART where PART_DESC like '%" + token.toUpperCase() + "%' OR PART_NAME LIKE '%"+ token.toUpperCase() +"%' OR OEM_NUMBER LIKE '%"+ token.toUpperCase() +"%'";
		 			if(sql.length() == 0)
		 			{
		 			
		 			//String sql ="select * from SHOP_PARTS_INFO where 
		 			 sql = temp;
		 			}
		 			else
		 			{
		 				
		 			sql = sql + " union " + temp;

		 			
		 			}
		 			
	 			}
		 }
		 			List<Part> invPart = new ArrayList<Part>();
		 			
		 		      System.out.println(sql);
		 			invPart = jdbcTemplate.query(sql, new PartRowMapper());
		 			
		 			if(!invPart.isEmpty()) {

		 				masterList = getInventorybyShopListPartList(shopl, invPart);

		 			}


		return masterList;
	}

	@Override
	public List<Inventory> getInventorybyShopListPartList(List<Shop> shopl,List<Part> partl) {
		// TODO Auto-generated method stub
		String pinClause="";
		for (int i = 0; i < partl.size(); i++) {
			Part p=partl.get(i);
			if(i ==0)
			{
				pinClause=p.getPartId().toString();
			}
			else
			{
			pinClause = pinClause +","+p.getPartId();
		    }
			
		}
		pinClause =" IN ("+pinClause+")";
		
		String sinClause="";
		for (int i = 0; i < shopl.size(); i++) {
			Shop s=shopl.get(i);
			if(i ==0)
			{
				sinClause=s.getShopId().toString();
			}
			else
			{
			sinClause = sinClause +","+s.getShopId();
		    }
			
		}
		sinClause =" IN ("+sinClause+")";
		
		String sql ="select * from SHOP_PARTS_INFO where PART_ID " + pinClause +" and SHOP_ID "+sinClause;
            System.out.println(sql);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Inventory> invList = new ArrayList<Inventory>();
			invList = jdbcTemplate.query(sql, new InventoryRowMapper());
			return invList;
	       }
}	
