package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class data {
	
	public static List<String> T=new ArrayList<String>();
	
	public static int taille() {
		return T.size();
	}

	public static String getT(int i) {
		return T.get(i);
	}

	public static void setT(String line) {
		T.add(line);
	}
	

}
