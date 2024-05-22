import java.util.Scanner;

//Classe sempre inicia com letra maiúscula

public class Principal{

 public static void main(String args[]){
	
	Scanner entradaDeDados = new Scanner (System.in); //Objeto java padrão para receber dados através do console. É uma classe com métodos para entrada de dados
	
	String nome; //variável que recebe uma cadeia de caracteres

	System.out.println("Digite o nome do Atleta");//trecho de código usado para apresentar a mensagem para o usuário
	
	nome = entradaDeDados.next(); //Estou armazenando o valor digitado pelo usuário na variável nome.

	System.out.println("O nome recebido foi:"+ nome);

 }

}