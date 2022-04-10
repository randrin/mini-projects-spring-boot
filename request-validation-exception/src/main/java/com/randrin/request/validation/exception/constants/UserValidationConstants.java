package com.randrin.request.validation.exception.constants;

public class UserValidationConstants {

    public static final String USER_NAME_REQUIRED = "User name is required";
    public static final String USER_EMAIL_REQUIRED = "User email is required";
    public static final String USER_MOBILE_REQUIRED = "User phone is required";
    public static final String USER_MOBILE_REGREG = "^\\d{10}$";
    public static final String USER_EXIST_WITH_EMAIL = "User already existed with email";
    public static final String USER_EXIST_WITH_NAME = "User already existed with name";
    public static final String USER_EXIST_WITH_MOBILE = "User already existed with mobile";
    public static final String USER_NOT_FOUND_WITH_ID = "User not found with id";
}
