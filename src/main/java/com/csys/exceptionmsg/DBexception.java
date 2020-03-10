package com.csys.exceptionmsg;

public class DBexception extends Exception {

	public DBexception(String msg) {
		super(msg);
	}
		public DBexception(String msg,Exception e){
			super (msg,e);
		}
		public DBexception(Exception e) {
			super(e);
		}
	}



