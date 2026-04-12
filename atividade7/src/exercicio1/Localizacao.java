package exercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Localizacao {
	private ArrayList<String> textos = new ArrayList<>();

    public Localizacao(String arquivo) {
        try {
        	FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha;

            while ((linha = br.readLine()) != null) {
                textos.add(linha);
            }

            br.close();
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
    }

    public String getTexto(int indice) {
        return textos.get(indice);
    }
}
