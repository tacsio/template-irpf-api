package com.tacsio.util;

public class Utils {

	private Utils() {	}

	public static String cleanCnpj(String cnpj) {
		return cnpj.trim().replace("/", "").replace(".", "").replace("-", "");
	}

}