package api.geradorDev.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class DateFormatter {
	public String formatar(LocalDate nascimento) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String formated = formatter.format(nascimento);
		return (formated);
		
	}
}
