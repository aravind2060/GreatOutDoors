package com.capgemini.greatoutdoors.util;

public class CurrentUserInfo 
{
   static boolean isAnyOneLoggedIn=false;
   static String  typeOfUser;
public static boolean isAnyOneLoggedIn() {
	return isAnyOneLoggedIn;
}

public static void setAnyOneLoggedIn(boolean isAnyOneLoggedIn) {
	CurrentUserInfo.isAnyOneLoggedIn = isAnyOneLoggedIn;
}

public static String getTypeOfUser() {
	return typeOfUser;
}

public static void setTypeOfUser(String typeOfUser) {
	CurrentUserInfo.typeOfUser = typeOfUser;
}
  
   
   
}
