package com.international_team.dss.patient;

import java.sql.Date;
import java.util.ArrayList;

public class Patient {
	String firstName;
	String lastName;
	String gender;
	private Gender sex;
	String email;
	Date dateOfBirth;
	String phoneNumber;
	String address;
	String socialSecurityNumber;
	private static final ArrayList<Patient> NEW_PATIENT = new ArrayList<Patient>();

	public static void main (String[] args) {
		Patient p1 = new Patient("332343432");
		NEW_PATIENT.add(p1);

	}

	public Patient() {}

	public Patient(String socialSecurityNumber) {
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.sex = getGender();
		this.email = getEmail();
		this.dateOfBirth = getDateOfBirth();
		this.phoneNumber = getPhoneNumber();
		this.address = getAddress();
		this.socialSecurityNumber = socialSecurityNumber;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) { this.lastName = lastName; }

	public Gender getGender() {
		return sex;
	}

	public void setGender(Gender sex) { this.sex = sex; }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { this.email = email; }

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) { this.address = address; }

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }

}
