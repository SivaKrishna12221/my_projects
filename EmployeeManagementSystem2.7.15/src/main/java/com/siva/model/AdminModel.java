package com.siva.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminModel {
	private Integer id;
	private String name;
	private String username;
	private String password;
}
