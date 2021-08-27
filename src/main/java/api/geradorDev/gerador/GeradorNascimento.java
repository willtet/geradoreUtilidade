package api.geradorDev.gerador;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GeradorNascimento {
	public String gerar() {

        GregorianCalendar gc = new GregorianCalendar();

        //Maior idade
        int yearFormated = Calendar.getInstance().get(Calendar.YEAR) - 18;
        int yearFormatedLimit = Calendar.getInstance().get(Calendar.YEAR) - 80;
        int year = randBetween(yearFormatedLimit, yearFormated);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return (gc.get(gc.YEAR) + "-" + String.format("%02d",(gc.get(gc.MONTH) + 1)) + "-" + String.format("%02d",gc.get(gc.DAY_OF_MONTH)));

    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
