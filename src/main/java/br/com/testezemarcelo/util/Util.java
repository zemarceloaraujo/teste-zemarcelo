package br.com.testezemarcelo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static String converteLocalDateToString(LocalDate data, String padrao) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao);
		return data.format(formatter);
		
	}

}
