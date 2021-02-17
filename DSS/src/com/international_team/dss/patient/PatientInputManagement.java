package com.international_team.dss.patient;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientInputManagement {

	private Scanner scanner;

	private static final String REGEX_EMAIL_VALIDATION = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	private static final String REGEX_SOCIAL_SECURITY_VALIDATION = "[0-9]+";
	private static final String REGEX_NAME_VALIDATION = "\\D*";
	private static final String REGEX_DATE_VALIDATION = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
			+ "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
	private final static String REGEX_PHONE_NUMBER_VALIDATION = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	private static Pattern pattern;
	private static Matcher matcher;

	public PatientInputManagement(Scanner scanner) {
		this.scanner = scanner;
	}

	public void createPatientRecord() {
		Patient patient = new Patient();
		patient.socialSecurityNumber = getSocialSecurityNumber("Social security number: ");
		patient.firstName = getFirstNameAndLastName("First name: ");
		patient.lastName = getFirstNameAndLastName("Last name: ");
		patient.gender = getGender("Gender: ");
		patient.email = getEmail("Email: ");
		patient.dateOfBirth = getDateOfBirth("Date of birth: ");
		patient.phoneNumber = getPhoneNumber("Phone number :");
		patient.address = getAddress("Address: ");
	}

	private String getSocialSecurityNumber(String msg) {
		String socialSecurityNumber;
		do {
			System.out.println(msg);
			socialSecurityNumber = scanner.next();
		} while (!isValidFormat(socialSecurityNumber, REGEX_SOCIAL_SECURITY_VALIDATION));
		return socialSecurityNumber;
	}

	private String getFirstNameAndLastName(String msg) {
		String firstNameOrLastName;
		do {
			System.out.println(msg);
			firstNameOrLastName = scanner.next();
		} while (!isValidFormat(firstNameOrLastName, REGEX_NAME_VALIDATION));
		return firstNameOrLastName;
	}

	private String getGender(String msg) {
		String gender;
		do {
			System.out.println(msg);
			gender = scanner.next();
		} while (!isValidGender(gender));
		return gender;
	}

	private String getEmail(String msg) {
		String email;
		do {
			System.out.println(msg);
			email = scanner.next();
		} while (!isValidFormat(email, REGEX_EMAIL_VALIDATION));
		return email;
	}

	private Date getDateOfBirth(String msg) {
		String dateOfBirth;
		do {
			System.out.println(msg);
			dateOfBirth = scanner.next();
		} while (!isValidFormat(dateOfBirth, REGEX_DATE_VALIDATION));
		return Date.valueOf(dateOfBirth);
	}

	private String getPhoneNumber(String msg) {
		String phoneNumber;
		do {
			System.out.println(msg);
			phoneNumber = scanner.next();
			scanner.nextLine();
		} while (!isValidFormat(phoneNumber, REGEX_PHONE_NUMBER_VALIDATION));
		return phoneNumber;
	}

	private String getAddress(String msg) {
		System.out.println(msg);
		String address = scanner.nextLine();
		return address;
	}

	private boolean isValidGender(String gender) {
		return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
	}

	private boolean isValidFormat(String userGiven, String regex) {
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(userGiven);
		return matcher.matches();
	}

}
