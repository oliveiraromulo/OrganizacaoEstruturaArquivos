package classes;

import java.io.*;

public class MesclaArquivos {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf1 = new RandomAccessFile("arq1.csv", "r");
		RandomAccessFile raf2 = new RandomAccessFile("arq2.csv", "r");
		Registro r1 = new Registro();
		Registro r2 = new Registro();
		r1.leRegistro(raf1);
		r2.leRegistro(raf2);
		String dados = " ";
		String novoArquivo = "arqMesclado.csv";
		File criaArquivo = new File(novoArquivo);
		BufferedWriter bw = new BufferedWriter(new FileWriter(criaArquivo, true));
		while(raf1.getFilePointer() < raf1.length()) {
			while(raf2.getFilePointer() < raf2.length()) {
				String chave1 = r1.getChave();
				String chave2 = r2.getChave();
				if(chave1.equals(chave2)) {
					dados = r1.getChave();
					dados = r1.getNome();
					dados = r1.getEmail();
					dados = r1.getTelefone();
					bw.write(dados);
				}else {
					dados = r2.getChave();
					dados = r2.getNome();
					dados = r2.getEmail();
					dados = r2.getTelefone();
					bw.write(dados);
				}
				bw.close();
			}
		}
		raf1.close();
		raf2.close();
	}
}
