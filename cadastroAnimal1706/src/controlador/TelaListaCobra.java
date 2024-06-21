package controlador;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Cobra;

public class TelaListaCobra {

	public void listaCobra(List<Cobra> listaCobra) {

		int quantidadeLinhas = listaCobra.size();

		String[][] tabelaString = new String[quantidadeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Cobra cobra : listaCobra) {

			tabelaString[posicaoLinha][posicaoColuna] = cobra.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = cobra.getCAF();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = cobra.getTipoVeneno();
			posicaoLinha++;

			posicaoColuna = 0;
		}

		String nomeColunas[] = { "Nome", "CAF", "TipoVeneno", "Preço", "CEP", "Localidade", "Logradouro", "Bairro", "UF" };

		JFrame frameListaCobra = new JFrame();

		frameListaCobra.setSize(500, 600);

		JTable tabelaCobra = new JTable(tabelaString, nomeColunas);

		tabelaCobra.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListaCobra = new JScrollPane(tabelaCobra);

		scrollPaneListaCobra.setPreferredSize(new Dimension(400,160));
		
		JPanel panelListaCobra = new JPanel();

		panelListaCobra.add(scrollPaneListaCobra);

		frameListaCobra.add(panelListaCobra);
		frameListaCobra.setVisible(true);

	}

}
