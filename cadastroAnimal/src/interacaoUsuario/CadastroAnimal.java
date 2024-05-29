package interacaoUsuario;

import java.util.List;
//import java.util.Scanner;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import entidade.Galinha;

public class CadastroAnimal {

	public Cachorro cadastroCachorro() {

		Cachorro cachorroEntidade = new Cachorro();

		cachorroEntidade.setNome(JOptionPane.showInputDialog("Digite o nome do animal: "));
		cachorroEntidade.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: ")));
		cachorroEntidade.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso: ")));
		cachorroEntidade.setCorPelo(JOptionPane.showInputDialog("Digite a cor do pelo: "));

		return cachorroEntidade;

	}

	public void imprimirCachorro(List<Cachorro> listaCachorro) {

		StringBuilder impressaoCachorroString = new StringBuilder();

		for (Cachorro cachorroItemLista : listaCachorro) {
			impressaoCachorroString.append("Nome: ").append(cachorroItemLista.getNome()).append("\n").append("Idade: ")
					.append(cachorroItemLista.getIdade()).append("\n").append("Peso: ")
					.append(cachorroItemLista.getPeso()).append("\n").append("Cor Pelo: ")
					.append(cachorroItemLista.getCorPelo()).append("\n").append("_____________________________")
					.append("\n");

		}

		JOptionPane.showMessageDialog(null, impressaoCachorroString.toString());

	}

	public Galinha cadastroGalinha() {

		Galinha galinhaEntidade = new Galinha();

		galinhaEntidade.setNome(JOptionPane.showInputDialog("Digite o nome do animal: "));
		galinhaEntidade.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: ")));
		galinhaEntidade.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso: ")));
		galinhaEntidade.setCorPena(JOptionPane.showInputDialog("Digite a cor da Pena: "));

		return galinhaEntidade;

	}

	public void imprimirGalinha(List<Galinha> listaGalinha) {

		StringBuilder impressaoGalinhaString = new StringBuilder();

		for (Galinha galinhaItemLista : listaGalinha) {
			impressaoGalinhaString.append("Nome: ").append(galinhaItemLista.getNome()).append("\n").append("Idade: ")
					.append(galinhaItemLista.getIdade()).append("\n").append("Peso: ")
					.append(galinhaItemLista.getPeso()).append("\n").append("Cor Pena: ")
					.append(galinhaItemLista.getCorPena()).append("\n").append("_____________________________")
					.append("\n");

		}

		JOptionPane.showMessageDialog(null, impressaoGalinhaString.toString());

	}

}
