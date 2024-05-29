package interacaoUsuario;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import entidade.Galinha;

public class Menu {

	public void menuInicial() {

		CadastroAnimal cadastroAnimal = new CadastroAnimal();
		Cachorro cachorroParaAddNaLista = new Cachorro();
		Galinha galinhaParaAddNaLista = new Galinha();
		List<Cachorro> cachorroLista = new ArrayList<Cachorro>();
		List<Galinha> galinhaLista = new ArrayList<Galinha>();

		int opcao;

		boolean menuResultado = true;
		// tudo que está dentro do while vai se repetir enquanto(while) a variavel
		// menuResultado for true(verdadeiro)
		while (menuResultado) {

			opcao = Integer
					.parseInt(JOptionPane.showInputDialog("Digite 1 para Cachorro " + "\n" + " Digite 2 para Galinha"
							+ "\n" + " Digite 3 para listar as Cachorros" + "\n" + " Digite 4 para listar as Galinhas" + "\n" + " Digite 5 para listaEncerrar" + "\n"

					));

			switch (opcao) { // Verificar o valor da variavel opcao
			case 1: { // Caso for 1 entra nesse caso
				cachorroParaAddNaLista = cadastroAnimal.cadastroCachorro();// VAI EXECUTAR ESSA LINHA
				cachorroLista.add(cachorroParaAddNaLista);
				break;
			}
			case 2: { // Caso for 2 entra nesse caso
				galinhaParaAddNaLista = cadastroAnimal.cadastroGalinha();
				galinhaLista.add(galinhaParaAddNaLista);

				break;
			}
			case 3: {
				cadastroAnimal.imprimirCachorro(cachorroLista);
				break;
			}
			case 4: {
				cadastroAnimal.imprimirGalinha(galinhaLista);
				break;
			}
			case 5: { // Caso for 2 entra nesse caso
				System.exit(0);
				break;
			}
			default: // Se não for nenhuma opcao entra aqui
				JOptionPane.showMessageDialog(null, "Insira 1 ou 2");
				break;
			}

		}
	}
}
