import java.util.Scanner;

//Classe sempre inicia com letra maiúscula

public class CadastroAnimal{

 public static void main(String args[]){
	
	Scanner entradaDeDados = new Scanner (System.in); //Objeto java padrão para receber dados atravCadastroAnimals do console. CadastroAnimal uma classe com mCadastroAnimaltodos para entrada de dados
	
	Animal objetoAnimal = new Animal(); //variável que recebe uma cadeia de caracteres

	Cachorro objetoCachorro = new Cachorro();
	Galinha  objetoGalinha  = new Galinha();


	//cachorro
	System.out.println("Digite o nome do Animal");	
	objetoCachorro.nomeAnimal = entradaDeDados.next();

	System.out.println("Digite a idade do Animal");	
	objetoCachorro.idade = Integer.parseInt(entradaDeDados.next());

	System.out.println("Qual a cor do pelo do cachorro:");	
	objetoCachorro.corPelo = entradaDeDados.next();

	//galinha
	System.out.println("Digite o nome do Animal");	
	objetoGalinha.nomeAnimal = entradaDeDados.next();

	System.out.println("Digite a idade do Animal");	
	objetoGalinha.idade = Integer.parseInt(entradaDeDados.next());

	System.out.println("Qual a cor da pena da galinha:");	
	objetoGalinha.corPena = entradaDeDados.next();


	System.out.println("O nome do animal recebido foi:"+ objetoCachorro.nomeAnimal);

	System.out.println("A idade do animal eh:"+ objetoCachorro.idade);

	System.out.println("A cor do pelo do cachorro:"+ objetoCachorro.corPelo);

	System.out.println("O nome do animal recebido foi:"+ objetoGalinha.nomeAnimal);

	System.out.println("A idade do animal eh:"+ objetoGalinha.idade);

	System.out.println("A cor da pena da galinha:"+ objetoGalinha.corPena);


 }

}