package com.teamnexters.bidulgi.common.response;

public interface BidulgiResponseCode {
	public int RESPONSE_TEST = 0;
	public int RESPONSE_REQUIRE_LOGIN  = 1;
	public int RESPONSE_LOGIN_SUCCESS = 2;
	public int RESPONSE_LOGIN_FAIL = 3;
	public int RESPONSE_REGISTRATION_FAIL = 4;
	public int RESPONSE_REGISTRATION_SUCCESS = 5;
	public int RESPONSE_LOGOUT_SUCCESS = 6;
	public int RESPONSE_SOLDIER_INFO = 7;
	public int RESPONSE_SOLDIER_SEARCH_FAIL = 8;
	public int RESPONSE_ADD_FRIEND_SOLDIER_FAIL = 9;
	public int RESPONSE_ADD_FRIEND_SOLDIER_SUCCESS = 10;
	public int RESPONSE_REMOVE_FRIEND_SOLDIER_SUCCESS = 11;
	public int RESPONSE_REMOVE_FRIEND_SOLDIER_FAIL = 12;
	public int RESPONSE_LIST_FRIEND_SOLDIER = 13;
	public int RESPONSE_NICE_AUTH_FAIL = 14;
	public int RESPONSE_NICE_AUTH_IMAGE = 15;
	public int RESPONSE_NICE_SMS_SUCCESS = 16;
	public int RESPONSE_NICE_SMS_FAIL = 17;
	public int RESPONSE_NICE_AUTH_SUCCESS = 18;
	public int RESPONSE_SEND_MESSAGE_SUCCESS = 19;	
	public int RESPONSE_SEND_MESSAGE_FAIL = 20;
	public int RESPONSE_LIST_SOLDIER_MESSAGE = 21;
	public int RESPONSE_LIST_USER_MESSAGE = 22;
	public int RESPONSE_REQUIRE_NICE_AUTH = 23;
	public int RESPONSE_LOGIN_DUPLICATE = 24;
	public int RESPONSE_KEEP_SESSION = 25;
	public int RESPONSE_NICE_ALREADY_AUTHED = 26;
	public int RESPONSE_LIST_ARTICLE = 27;
	public int RESPONSE_WRITE_ARTICLE_SUCCESS = 28;
	public int RESPONSE_WRITE_ARTICLE_FAIL = 29;
	public int RESPONSE_WRITE_COMMENT_SUCCESS = 30;
	public int RESPONSE_WRITE_COMMENT_FAIL = 31;
	public int RESPONSE_LIST_COMMENT = 32;
	public int RESPONSE_READ_ARTICLE = 33;
}