package com.cleo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream("db.properties"));
	//	Class.forName(properties.getProperty())

		System.out.println("Hello world!");
	}
}