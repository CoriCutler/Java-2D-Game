package com.sorax.Knights_Journey.database;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.sorax.Knights_Journey.Game;
import com.sorax.Knights_Journey.entity.mob.player.Player;

public class Login extends Database{
	
	private static boolean checkAccount(String Password, String Username) {
		try {
			database();
		} catch (SQLException e) {e.printStackTrace();}
		
		if(username.contains(Username)){
			for(int i = 0; i < username.size(); i++) {
				if(username.get(i).equals(Username)) {
					if(password.get(i).equals(Password)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static void login(){
		String username = null;
		String password = null;
		username = JOptionPane.showInputDialog("please enter username");
		password = JOptionPane.showInputDialog("Please enter password");
		
		if(checkAccount(password, username)) {
			System.out.println(username + " Logged in");
			Player.username = username;
		}else {
			System.exit(0);
		}
	}
 }
