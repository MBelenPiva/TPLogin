package com.example.tp08.Utilis;

public class LoginHelper {

    private static final String APIKey = "81a327d5";
    private static final String BaseURL = "http://api.polshu.com.ar/api/v1/login/usuario/password";

    public static String getSearchURL(String strSearch){
        String strReturnValue;
        strReturnValue = String.format("%s?apikey=%s&s=%s",BaseURL, APIKey, strSearch);
        return strReturnValue;
    }

    public static String getLoginURL(String strId){
        String strReturnValue;
        strReturnValue = String.format("%s?apikey=%s&i=%s",BaseURL, APIKey, strId);
        return strReturnValue;
    }

}
