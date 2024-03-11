package com.example.demo.Constants;

public class Database_Table {
    public static final String USER = "user";
   
    public enum DeletedStatus {
        DELETED,
        NOT_DELETED
    }
    
    public enum UserVerify {
        VERIFIED,
        NOT_VERIFIED
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
}
