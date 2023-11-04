package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public abstract class PasswordCryptography {

	private static String cryptoPassword(String pass, int key) {
		char[] passToChar = pass.toCharArray();
		char[] newPasswordArray = new char[passToChar.length];
		for (int i = 0; i < passToChar.length; i++) {
			int newCharValue = passToChar[i] - key;
			newPasswordArray[i] = (char) newCharValue;
		}
		return new String(newPasswordArray);
	}

	public static String cypher(String pass) {
		return cryptoPassword(pass, 13);
	}

	public static String decrypt(String pass) {
		return cryptoPassword(pass, -13);
	}
}
