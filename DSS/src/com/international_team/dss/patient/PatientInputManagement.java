package com.international_team.dss.patient;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientInputManagement {

	private Scanner scanner;
	private static final String REGEX_EMAIL_VALIDATION = "^(.+)@(.+)$";
	private final static String REGEX_SOCIAL_SECURITY_VALIDATION = "[0-9]+" + "^.{3}$";
	private final static String REGEX_NAME_VALIDATION = ".*\\d.*" + "\\\\b\\\\w{2,20}\\\\b";
	private final static String REGEX_DATE_VALIDATION = "\\d{4}-\\d{2}-\\d{2}";
	private final static String REGEX_PHONE_NUMBER_VALIDATION = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	private static Pattern pattern;
	private static Matcher matcher;

	public PatientInputManagement(Scanner scanner) {
		this.scanner = scanner;
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

	private String getFirstNameAndLastName(String msg) {
		System.out.println(msg);
		String firstNameOrLastName;
		do {
			firstNameOrLastName = scanner.next();
			scanner.nextLine();
		} while (!isValidFormat(firstNameOrLastName, REGEX_NAME_VALIDATION));
		return firstNameOrLastName;
	}

	private String getGender(String msg) {
		System.out.println(msg);
		String gender;
		do {
			gender = scanner.next();
			scanner.nextLine();
		} while (isValidGender(gender));
		return gender;
	}

	private String getEmail(String msg) {
		System.out.println(msg);
		String email;
		do {
			email = scanner.next();
			scanner.nextLine();
		} while (isValidFormat(email, REGEX_EMAIL_VALIDATION));
		return email;
	}

	private Date getDateOfBirth(String msg) {
		System.out.println(msg);
		String dateOfBirth;
		do {
			dateOfBirth = scanner.next();
			scanner.nextLine();
		} while (isValidFormat(dateOfBirth, REGEX_DATE_VALIDATION));
		return Date.valueOf(dateOfBirth);
	}

	private String getPhoneNumber(String msg) {
		System.out.println(msg);
		String phoneNumber;
		do {
			phoneNumber = scanner.next();
			scanner.nextLine();
		} while (isValidFormat(phoneNumber, REGEX_PHONE_NUMBER_VALIDATION));
		return phoneNumber;
	}

	private String getAddress(String msg) {
		System.out.println(msg);
		String address = scanner.next();
		scanner.nextLine();
		return address;
	}

	private String getSocialSecurityNumber(String msg) {
		System.out.println(msg);
		String socialSecurityNumber;
		do {
			socialSecurityNumber = scanner.next();
			scanner.nextLine();
		} while (isValidFormat(socialSecurityNumber, REGEX_SOCIAL_SECURITY_VALIDATION));
		return socialSecurityNumber;
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
