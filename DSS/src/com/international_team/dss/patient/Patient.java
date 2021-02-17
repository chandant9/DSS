package com.international_team.dss.patient;

import java.sql.Date;

public class Patient {

	String socialSecurityNumber;
	String firstName;
	String lastName;
	String gender;
	String email;
	Date dateOfBirth;
	String phoneNumber;
	String address;

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

}
