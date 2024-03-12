package com.example.demo.Constants;

public class Database_Table {
    public static final String USER = "user";
    public static final String AUTH_TOKEN="auth_token";
    public static final String COUNTRY="country";
    public static final String STATE="state";
    public static final String CITY="city";
    public static final String ZIPCODE="zipcode";
    public static final String USER_ADDRESS="user_address";
   
    public enum DeletedStatus {
        DELETED,
        NOT_DELETED
    }
    
    public enum UserVerify {
        VERIFIED,
        NOT_VERIFIED
    }
    public static String getUser() {
		return USER;
	}

	public static String getAuthToken() {
		return AUTH_TOKEN;
	}

	public static String getCountry() {
		return COUNTRY;
	}

	public static String getState() {
		return STATE;
	}

	public static String getCity() {
		return CITY;
	}

	public static String getZipcode() {
		return ZIPCODE;
	}

	public static String getUserAddress() {
		return USER_ADDRESS;
	}

	public enum Status {
        ACTIVE,
        INACTIVE
    }
    public enum Roles {
    	  ADMIN,
        USER,
        CHEF
    }
    public enum Food_Type {
    	  VEG,
    	  NON_VEG,
    	  BOTH
    	}
    
    public enum DeviceType {
        ANDROID,
        IOS
    }
}
