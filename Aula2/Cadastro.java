import java.util.Scanner;

//Classe sempre inicia com letra maiúscula

public class Cadastro{

 public static void main(String args[]){
	
	Scanner entradaDeDados = new Scanner (System.in); //Objeto java padrão para receber dados através do console. É uma classe com métodos para entrada de dados
	
	Animal objetoAnimal = new Animal(); //variável que recebe uma cadeia de caracteres

	System.out.println("Digite o nome do Animal");//trecho de código usado para apresentar a mensagem para o usuário
	
	objetoAnimal.nomeAnimal = entradaDeDados.next(); //Estou armazenando o valor digitado pelo usuário na variável nome.

	System.out.println("O nome do animal recebido foi:"+ objetoAnimal.nomeAnimal);

	System.out.println("Digite a idade do Animal");//trecho de código usado para apresentar a mensagem para o usuário
	
	objetoAnimal.idade = Integer.parseInt(entradaDeDados.next()); //Estou armazenando o valor digitado pelo usuário na variável nome.

	System.out.println("A idade do animal eh:"+ objetoAnimal.idade);


 }

}