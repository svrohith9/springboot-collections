package com.svrohith9.springbootmongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "data")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@JsonProperty("First Name")
	@Field("First Name")
	private String firstName;
	@JsonProperty("Phone No")
	@Field("Phone No")
	private Object mobileNumber;
}
