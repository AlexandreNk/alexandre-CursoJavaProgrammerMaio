package cadastroAnimal;

import java.util.Scanner; 

import entidade.Animal;

public class Principal{

	public static void main(String[] args) {

			
			Scanner entradaDados = new Scanner(System.in);
			
			Animal animal = new Animal();
								
			System.out.println("Nome do animal");
			
			String nomeVar = entradaDados.next();
			
			animal.setNome(nomeVar);

			System.out.println("Idade");

			int idadeVar = Integer.parseInt(entradaDados.next());
			
			animal.setIdade(idadeVar);
			
			System.out.println("Peso");

			int pesoVar = Integer.parseInt(entradaDados.next());
			
			animal.setPeso(pesoVar);

			
			//System.out.println("Peso");
			//objetoAnimal.peso = Integer.parseInt(entradaDados.next());
			
			double preco = calcularPreco(pesoVar);
			
			imprimirResultadoNoConsole(animal);
			
//			System.out.println("O nome encapsulado é "
//			+ animal.getNome()  + "A idade é "
//			+ animal.getIdade() + "O peso é "
//			+ animal.getPeso());
			
	}
	
	public static void imprimirResultadoNoConsole(Animal animal) {
		
		System.out.println("Nome do Animal:" + animal.getNome());
		System.out.println("Idade do Animal:" + animal.getIdade());
		System.out.println("Peso do Animal:" + animal.getPeso());
		System.out.println("Preco do Animal:" + preco);
		
	}
	
	public static double calcularPreco(int peso) {
		
		double preco = peso * 50;
		
		return preco;
	}

}
