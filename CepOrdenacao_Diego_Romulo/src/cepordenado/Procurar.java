package cepordenado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Procurar {
	
	private CEP c;
	private String numCep;
	private RandomAccessFile randomFile; 
	private static int numLoops;
	
	public Procurar(String numCep) throws IOException {
		
		try {
			this.numCep = numCep;
			this.randomFile = new RandomAccessFile(new File("arquivo/CepOrdenadoMenor.dat").getAbsolutePath(), "r");
			this.c = new CEP();
		}
		catch (FileNotFoundException exception) {
			System.out.println("Arquivo não encontrado");
		}
	}
	
	public void retornaResultado() {
        try{
            long raiz = 0;
            long bot = ((this.randomFile.length()/300)-1);
            long meio = 0;
           
            while (raiz <= bot) {
                meio = ( ( raiz + bot )  / 2 );
                this.randomFile.seek(meio*300);
                this.c.leEndereco(this.randomFile);
                
                if(Integer.parseInt(this.c.getCep())==Integer.parseInt(this.numCep)){
                    System.out.println(this.c.getLogradouro());
                    System.out.println(this.c.getBairro());
                    System.out.println(this.c.getCidade());
                    System.out.println(this.c.getEstado());
                    System.out.println(this.c.getSigla());
                    System.out.println(this.c.getCep());
                    break;
                }
                
                else if (Integer.parseInt( this.c.getCep()) > Integer.parseInt(this.numCep) )
                         bot = meio - 1; //filho da esquerda
                else if (Integer.parseInt( this.c.getCep() ) < Integer.parseInt(this.numCep) )
                         raiz = meio + 1; //filho da direita
                
                numLoops++;
            }
            System.out.println("Numero total de consultas: "+numLoops);
            this.randomFile.close();
        }
        catch(Exception e) {
        	System.out.println("Tente novamente, cep nao encontrado");
        }    	
    }
}
