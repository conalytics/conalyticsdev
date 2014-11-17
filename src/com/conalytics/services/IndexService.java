package com.conalytics.services;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.domain.Inventory;
import com.conalytics.domain.Part;
import com.conalytics.domain.Shop;


public class IndexService {
	
	@Autowired
	DataSource dataSource;
	
    @Autowired
    PartService pService;

    // JdbcDirectory jdbcDir = new JdbcDirectory(dataSource, new MySQLDialect(), "InventoryIndexTable"); 
		
		//jdbcDir.create();

	
	public  void indexParts() throws Exception
	{
		//StandardAnalyzer analyzer = new StandardAnalyzer();  
		  
		
		  
	}

	
	
	
}
