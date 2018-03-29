package arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public class main {
	
	public static void main(String[] args) throws Exception {
		
		int indice = 1;
		
		RandomAccessFile f = new RandomAccessFile("cep_ordenado.dat", "r");
		
		Endereco end = new Endereco();
		end.leEndereco(f);
		String siglaUF = end.getSigla();
		String infos = "";
		
		String arquivo = "UF-"+ end.getSigla() + ".txt";
		
		File criaArquivo = new File(arquivo);
		BufferedWriter bw;
		
		
		f.seek(0);
		while(f.getFilePointer() < f.length())//analisa o ponto de EOF
		{
			// System.out.println(f.getFilePointer());
			
			if(siglaUF.equals(end.getSigla())) {
				
				infos += end.getBairro();
				infos += end.getCep();
				infos += end.getCidade();
				infos += end.getEstado();
				infos += end.getLogradouro();
				infos += end.getSigla();
				
				bw = new BufferedWriter(new FileWriter(criaArquivo, true));
				bw.write(infos);
				bw.close();
			}else {
				arquivo = "UF-" + end.getSigla() + ".txt";
				indice++;
				criaArquivo = new File(arquivo);
			}
			
			siglaUF = end.getSigla();
			end.leEndereco(f);
		}
		f.close();
	}
	
}
