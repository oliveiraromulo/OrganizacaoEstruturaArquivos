package classes;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GeraCSVDesordem {
	public static void main(String[] args) throws Exception {
		int i;
		ArrayList<Registro> reg = new ArrayList<Registro>();
		String novoArquivo = "dadosdesordem.csv";
		File criaArquivo = new File(novoArquivo);
		RandomAccessFile raf = new RandomAccessFile("arq1.dat", "r");
		//raf.seek(0);
		while(raf.getFilePointer() < raf.length()) {
			Registro r = new Registro();
			r.leRegistro(raf);
			reg.add(r);
		}
		raf.close();
		System.out.println(reg);
		
		RandomAccessFile raf2 = new RandomAccessFile("arq2.dat", "rw");
		for(Registro r: reg) {
			r.escreveRegistro(raf2);
		}
		raf2.close();
	}
	
}
