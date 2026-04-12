package exercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistroLog {
	public static void registro(String descricao) {
		try {
			FileWriter fw = new FileWriter("registro-log.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Calendar cal = Calendar.getInstance();
			String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
			
			bw.write("[" + dataHora + "] " + descricao + "\n");
			bw.close();
			
		} catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
