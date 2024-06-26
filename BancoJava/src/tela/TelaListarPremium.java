package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaListarPremiumControlador;
import entidade.Premium;

public class TelaListarPremium {

	public void listarPremium(List<Premium> listaPremiums) {

		int quantidadeDeLinhas = listaPremiums.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Premium premium : listaPremiums) {

			tabelaString[posicaoLinha][posicaoColuna] = premium.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = premium.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = premium.getValorDaAnuidade().toString();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "ANUIDADE" };

		JFrame frameListarPremium = new JFrame();

		frameListarPremium.setSize(475, 450);

		JTable tabelaPremiums = new JTable(tabelaString, nomeColunas);
		tabelaPremiums.setSize(1000, 1000);
		tabelaPremiums.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarPremium = new JScrollPane(tabelaPremiums);
		scrollPaneListarPremium.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarPremium = new JPanel();
		panelListarPremium.setSize(1000, 1000);
		JButton botaoMenu = new JButton("MENU");

		JButton botaoDetalhar = new JButton("DETALHAR");

		JTextField cpfTextField = new JTextField(10);

		panelListarPremium.add(cpfTextField);
		panelListarPremium.add(botaoDetalhar);

		panelListarPremium.add(scrollPaneListarPremium);
		panelListarPremium.add(botaoMenu);
		frameListarPremium.add(panelListarPremium);
		frameListarPremium.setVisible(true);

		TelaListarPremiumControlador premiumControlador = new TelaListarPremiumControlador(frameListarPremium,
				cpfTextField);
		botaoMenu.addActionListener(premiumControlador);
		botaoDetalhar.addActionListener(premiumControlador);
	}
}
