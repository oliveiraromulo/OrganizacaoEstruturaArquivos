package classes;

import java.io.*;

public class VerificaTerminaCom {
	public static void main(String[] args) throws Exception{	
		RandomAccessFile raf = new RandomAccessFile("arq1.csv", "r");
		Registro r = new Registro();
		r.leRegistro(raf);
		String email = r.getEmail();
		String dados = " ";
		String novoArquivo = "arq3.csv";
		File criaArquivo = new File(novoArquivo);
		BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivo, true));
		while(raf.getFilePointer() < raf.length()) {
			String email2 = r.getEmail();
			if(terminaCom(email, "gmail.com") == true) {
				dados = r.getChave();
				dados = r.getNome();
				dados = r.getEmail();
				dados = r.getTelefone();
				bw.write(dados);
			}
		}
		bw.close();
		raf.close();
	}
}
