package com.csys.util;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.csys.dao.imp.MatchDataDaoImp;
import com.csys.exception.DBexception;

public class Readcsv {
	
	 public static void main(String[] args) throws IOException, DBexception {
	 
	        Reader in = new FileReader("D:\\MatchDetail.csv");
	        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
	        for (CSVRecord record : records) {
	            String capno = record.get("CAP NO");
	            String format = record.get("FORMAT");
	            String runs = record.get("RUNS");
	            int run = Integer.parseInt(runs);
	            MatchDataDaoImp object = new MatchDataDaoImp();
	            object.addMatchDetail(capno, format, run);
	        }
	 
	    }
	 
	}


