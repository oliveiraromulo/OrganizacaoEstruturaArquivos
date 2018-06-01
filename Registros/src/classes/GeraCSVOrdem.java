package classes;

import java.io.*;
import java.util.Scanner;

public class GeraCSVOrdem {
	public static void main(String[] args) throws IOException {
	    FileOutputStream fout = new  FileOutputStream("arq1.dat");
	    PrintWriter pw = new PrintWriter(fout);
	    Scanner ler = new Scanner(System.in);
	    pw.println("chave,nome,email,telefone");
	    int op, vChave=1;
	    do {
	    	System.out.println("Insira a sua opcao: \n1-Novo Registro \n2-Sair");
		    op = ler.nextInt();
	    	if(op==1) {
			    Registro r = new Registro();
			    System.out.println("Insira seu nome: ");
			    String nome = ler.next();
			    r.setNome(nome);
			    System.out.println("Insira seu email: ");
			    String email = ler.next();
			    r.setEmail(email);
			    System.out.println("Insira seu telefone: ");
			    String telefone = ler.next();
			    r.setTelefone(telefone);
			    String vChaveS = String.valueOf(vChave);
			    r.setChave(vChaveS);
			    System.out.println("Chave de numero "+ vChave +" atribuida!");
			    pw.println(r.getChave() + "," + r.getNome() + "," + r.getEmail() + "," + r.getTelefone());
			    vChave++;
	    }
	   }while(op!=2);
	    pw.close();
	    fout.close();
	}
}
	    


/*r.chave = "12345678";
r.nome = "Romulo";
r.email = "romulo.silva.11@hotmail.com";
r.telefone = "997203642";*/
