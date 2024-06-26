package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaSelecionarAlterarPremiumControlador;
import entidade.Premium;

public class TelaSelecionarAlterarPremium {

	public void alterarPremium(List<Premium> listaPremiums) {

		int quantidadeDeLinhas = listaPremiums.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Premium premium : listaPremiums) {

			tabelaString[posicaoLinha][posicaoColuna] = premium.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = premium.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = premium.getLimiteCredito().toString();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "LIMITE_CREDITO" };

		JFrame framealterarPremiums = new JFrame();

		framealterarPremiums.setSize(475, 450);

		JTable tabelaPremiums = new JTable(tabelaString, nomeColunas);
		tabelaPremiums.setSize(1000, 1000);
		tabelaPremiums.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarPremium = new JScrollPane(tabelaPremiums);
		scrollPaneListarPremium.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarPremium = new JPanel();
		panelListarPremium.setSize(1000, 1000);

		panelListarPremium.add(scrollPaneListarPremium);

		JTextField cpf = new JTextField(10);
		panelListarPremium.add(cpf);

		JButton botaoalterar = new JButton("ALTERAR");
		panelListarPremium.add(botaoalterar);

		framealterarPremiums.add(panelListarPremium);
		framealterarPremiums.setVisible(true);

		TelaSelecionarAlterarPremiumControlador alterarPremiumControlador = new TelaSelecionarAlterarPremiumControlador(
				framealterarPremiums, cpf);
		botaoalterar.addActionListener(alterarPremiumControlador);
	}

}
