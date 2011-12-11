package com.colorcc.user.register.constant;

public enum UserStatus {

	UNKNOOWN("unknown"),

	UNCONFIRMED("unconfirmed"),

	OFFLINE("offline"),

	ONLINE("online"), HIDDEN("hidden");

	private String value;

	private UserStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
