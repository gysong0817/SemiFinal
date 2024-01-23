package com.miniproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
	private int userNo;
	private String userId;
	private String password;
	private String name;
	private String gender;
	private String phone;
	private String admin;
	
	@Builder
	public UserDTO(int userNo, String userId, String password, String name, String gender, String phone, String admin) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.admin = admin;
	}
}