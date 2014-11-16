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
		  
		IndexWriter writer = new IndexWriter(jdbcDir, analyzer, true);  
		
		List<Part> lpart=null;
		lpart=pService.getPartsdata();

		for (int i = 0; i < lpart.size(); i++) {
			Part pr=lpart.get(i); 
	        Document d = new Document();  
	        d.add(new Field("partId", pr.getPartId().toString(), Field.Store.YES, Field.Index.NO));  
	        d.add(new Field("autoId", pr.getAutoId().toString(), Field.Store.YES, Field.Index.NO));  
	        d.add(new Field("partName", pr.getPartName().toString(), Field.Store.YES, Field.Index.TOKENIZED)); 
	        d.add(new Field("partDesc", pr.getPartDesc().toString(), Field.Store.YES,  Field.Index.TOKENIZED));  
	        d.add(new Field("oemNumber", pr.getOemNumber().toString(), Field.Store.YES,  Field.Index.TOKENIZED));  
	        writer.addDocument(d);  
	    } 
		  
	}

	
	
	
}
