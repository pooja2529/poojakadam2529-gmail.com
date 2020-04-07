package com.example.demo.service;

public class ValidateDynamicField 
{
	public static  final String type= "$username$|$time$|$mobile$";
	
	static String t[]=type.split("\\|");

	public static String getType(String status)
	{
		
		String temp=null;
		for(int i=0;i<t.length;i++)
		{
			if(t[i]==status)
			{
				return temp;
			}
		}
		
		
		return temp;
	}
}
