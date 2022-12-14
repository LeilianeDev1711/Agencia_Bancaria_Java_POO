package Utilitarios;

import java.text.DecimalFormat; 
import java.text.NumberFormat; 

public class Uteis {

	static NumberFormat formatando_valores = new DecimalFormat("R$ #,##0.00"); 
	
	public static String doubleToString(Double valor) {
		return formatando_valores.format(valor); 
	}
}