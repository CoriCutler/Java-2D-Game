package com.sorax.Knights_Journey.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.sorax.Knights_Journey.Game;

public abstract class Database{
		private static String Password = "Password";
		protected static Connection myConn = null;
		protected static Statement myStmt = null;
	    protected static ResultSet myRs = null;
	    
	    protected static ArrayList<String> username = new ArrayList<String>();
	    protected static ArrayList<String> password = new ArrayList<String>();
	    protected static ArrayList<Integer> x = new ArrayList<Integer>();
	    protected static ArrayList<Integer> y = new ArrayList<Integer>();
	    
	public static void database() throws SQLException {
		System.out.println(Game.multiplayer);
		  if(Game.multiplayer){  
			try {
		        myConn = DriverManager.getConnection("jdbc:mysql://10.1.17.127:3306/user", "root", Password);
		        myStmt = myConn.createStatement();
		        myRs = myStmt.executeQuery("select * from user.`table`");
		        
		        while (myRs.next()) {
		        	if(!username.contains(myRs.getString("username"))) username.add(myRs.getString("username"));
		        	if(!password.contains(myRs.getString("password"))) password.add(myRs.getString("password"));
		        	if(!x.contains(myRs.getInt("x"))) x.add(myRs.getInt("x"));
		        	if(!y.contains(myRs.getInt("y"))) y.add(myRs.getInt("y"));
		        }
		    }
		    catch (Exception exc) {
		        exc.printStackTrace();
		    }
		    finally {
		        if (myRs != null) {
		            myRs.close();
		        }
		
		        if (myStmt != null) {
		            myStmt.close();
		        }
		
		        if (myConn != null) {
		            myConn.close();
		        }
		    }
		 } 
	}
 }