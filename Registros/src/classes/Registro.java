package classes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Registro {
	  String chave;
	  String nome;
	  String email;
	  String telefone;

	  public void setChave(String chave){
	    this.chave = chave;
	  }

	  public String getChave(){
	    return chave;
	  }

	  public void setNome(String nome){
	    this.nome = nome;
	  }

	  public String getNome(){
	    return nome;
	  }

	  public void setEmail(String email){
	    this.email = email;
	  }

	  public String getEmail(){
	    return email;
	  }

	  public void setTelefone(String telefone){
	    this.telefone = telefone;
	  }

	  public String getTelefone(){
	    return telefone;
	  }
	  
	  public void leRegistro(DataInput di) throws IOException{
		  
		  String linha = di.readLine();
		  System.out.println(linha);
		  String colunas[] = linha.split(",");
		  this.chave = colunas[0];
		  this.nome = colunas[1];
		  this.email = colunas[2];
		  this.telefone = colunas[3];
	  }

//	  public void leRegistro(DataInput di) throws IOException{
//		  byte chave[] = new byte[2];
//		  byte nome[] = new byte[72];
//		  byte email[] = new byte[72];
//		  byte telefone[] = new byte[8];
//		  
//		  di.readFully(chave);
//		  di.readFully(nome);
//		  di.readFully(email);
//		  di.readFully(telefone);
//		  di.readByte(); // Ultimo espaco em branco
//		  di.readByte(); // Quebra de linha
//		  
//		  //Necessita mesmo do CHARSET??
//		  
//		  Charset enc = Charset.forName("ISO-8859-1");
//		  
//		  this.chave = new String(chave, enc);
//		  this.nome = new String(nome, enc);
//		  this.email = new String(email, enc);
//		  this.telefone = new String(telefone, enc);
//	  }
	  
	  public void escreveRegistro(RandomAccessFile dop) throws IOException{
		  dop.writeBytes(this.chave);
		  dop.write(',');
		  dop.writeBytes(this.nome);
		  dop.write(',');
		  dop.writeBytes(this.email);
		  dop.write(',');
		  dop.writeBytes(this.telefone);
		  dop.writeChar('\n');
	  }
	  
}
