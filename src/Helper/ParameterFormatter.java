import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParameterFormatter {

    //Formata as datas para  dd/MM/yyyy
    public static String formatOfDate(LocalDate date) {
        DateTimeFormatter newDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(newDateFormat);
    }

    //Formata os salarios para 999.999,99
    public static String formatOfSalary(BigDecimal salary) {

        //Seta a região dos numeros
        Locale localeBR = new Locale("pt", "BR");

        // Criando um padrao ###,###.## para os numeros
        DecimalFormat salaryFormat = new DecimalFormat("###,###.##", new DecimalFormatSymbols(localeBR));

        return salaryFormat.format(salary);
    }
}