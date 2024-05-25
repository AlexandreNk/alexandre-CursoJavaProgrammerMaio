package cadastroAtleta;

import java.util.Scanner;
import entidade.Atleta;

public class Principal {

	public static void main(String[] args) {
	
		Scanner entradaDeDados = new Scanner (System.in); 
		
		Atleta atleta = new Atleta();
		
		System.out.println("O nome encapsulado é " + atleta.getNome());
		
		System.out.println("Digite a idade");
		
		int idadeVar = Integer.parseInt(entradaDeDados.next());
		
		atleta.setIdade(idadeVar);
		
	}

}
