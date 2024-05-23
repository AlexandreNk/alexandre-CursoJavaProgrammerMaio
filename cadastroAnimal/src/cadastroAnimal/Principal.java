package cadastroAnimal;

import java.util.Scanner; 

import entidade.Animal; 

public class Principal {

	public static void main(String[] args) {

			Animal objetoAnimal = new Animal();

			Scanner entradaDados = new Scanner(System.in);
			
			System.out.println("Informe o nome do animal");
			objetoAnimal.nome = entradaDados.next();
			
			System.out.println("Idade");
			objetoAnimal.idade = Integer.parseInt(entradaDados.next());
			
			System.out.println("Peso");
			objetoAnimal.peso = Integer.parseInt(entradaDados.next());
			
			objetoAnimal.preco = calcularPreco(objetoAnimal.peso);
			
			imprimirResultadoNoConsole(objetoAnimal);
	}
	
	public static void imprimirResultadoNoConsole(Animal animal) {
		
		System.out.println("Nome do Animal:" + animal.nome);
		System.out.println("Idade do Animal:" + animal.idade);
		System.out.println("Peso do Animal:" + animal.peso);
		System.out.println("Preco do Animal:" + animal.preco);
		
	}
	
	public static double calcularPreco(int peso) {
		
		double preco = peso * 50;
		
		return preco;
	}

}
