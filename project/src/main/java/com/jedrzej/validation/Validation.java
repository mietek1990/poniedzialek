package com.jedrzej.validation;

public class Validation{
	
	public static boolean isNumeric(String text)  
	{  
	  try  
	  {  
	    int tmp = Integer.parseInt(text);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
}
