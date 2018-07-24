package com.school.service.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {

	
	private static final String EMAIL_PATTERN = "^[[a-zA-Z0-9:_@!#$%&�*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_\\!#$%&�*+/=?`{|}~^-]+)]{1,64}$*@[[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)]{2,255}$*$";
	
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);


	private StringUtil() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isNullAndEmpty(String data) {
		return (data == null || "".equals(data.trim()));
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotNullNEmpty(List list) {
		return (list != null && !list.isEmpty());
	}

	public static boolean isNull(Object input) {
		return (input == null);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isListNotNullNEmpty(List list) {
		return (list != null && !list.isEmpty());
	}

	@SuppressWarnings("rawtypes")
	public static boolean isListNullNEmpty(List list) {
		return (list == null || list.isEmpty());
	}

	/**
	 * Checks if is array null N empty.
	 *
	 * @param array
	 *            the array
	 * @return true, if is array null N empty
	 */
	public static boolean isArrayNullNEmpty(String[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method to convert String List to String array
	 * 
	 * @param featureList
	 * @return
	 */
	public static String convertListToString(List<String> featureList) {

		if (StringUtil.isListNotNullNEmpty(featureList)) {
			StringBuilder sb = new StringBuilder();
			for (String feature : featureList) {
				sb.append(feature + ",");
			}
			return sb.toString().substring(0, sb.toString().length() - 1);
		}
		return "";
	}

	public static String[] converArray(String data) {
		if (!isNullAndEmpty(data)) {
			String arrayData[] = data.split(",");
			return arrayData;
		}
		return null;
	}

	public static String convertString(String[] arrayData) {
		if (arrayData != null && arrayData.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (String arr : arrayData) {
				sb.append(arr + ",");
			}
			return sb.toString().substring(0, sb.toString().length() - 1);
		}
		return "";
	}

	/**
	 * Method get Long value from String
	 * 
	 * @param str
	 * @return
	 */
	public static Long getLong(String str) {
		if (isNullAndEmpty(str)) {
			return 0L;
		} else {
			return Long.valueOf(str);
		}
	}

	/**
	 * Method to create String category
	 * 
	 * @param serviceProvider
	 * @return serviceProviderId
	 */
	public static boolean isValidAlfaNumeric(String data) {
		String pattern = "^[a-zA-Z0-9]*$";
		return data.matches(pattern);
	}

	/**
	 * Method to Validate input fields
	 * 
	 * @return boolean
	 */
	public static boolean isValidAlphaNumericWithSpace(String data) {
		String pattern = "^[a-zA-Z0-9-\\_ ]*$";
		return data.matches(pattern);
	}

	/**
	 * Method to Validate input fields
	 * 
	 * @return boolean
	 */
	public static boolean isValidDeviceRegex(String data) {
		String pattern = "^[a-zA-Z0-9-\\_/ ]*$";
		return data.matches(pattern);
	}

	public static boolean validateEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Method to validate Mobile Number
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean validatePhone(String phone) {
		boolean flag = true;
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(phone);
		flag = matcher.matches();
		return flag;
	}

	public static Boolean checkEquality(String newValue, String oldValue, boolean mand) {
		if (mand)
			return (newValue.trim().equals(oldValue.trim())) ? true : false;
		else {
			newValue = (StringUtil.isNullAndEmpty(newValue)) ? "" : newValue.trim();
			oldValue = (StringUtil.isNullAndEmpty(oldValue)) ? "" : oldValue.trim();
			return (newValue.equals(oldValue)) ? true : false;
		}

	}

	 
}