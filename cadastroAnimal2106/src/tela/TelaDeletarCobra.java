package tela;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.TelaDeletarCobraControlador;
import entidade.Cobra;

public class TelaDeletarCobra {

	public void chamarTelaDeletarCobra(List<Cobra> listaCobra) {

		int quantidadeDeLinhas = listaCobra.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Cobra cobra : listaCobra) {

			tabelaString[posicaoLinha][posicaoColuna] = cobra.getCAF();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = cobra.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = cobra.getTipoVeneno();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CAF", "NOME", "TIPOVENENO" };

		JFrame frameDeletarCobra = new JFrame();

		frameDeletarCobra.setSize(475, 450);

		JTable tabelaCobra = new JTable(tabelaString, nomeColunas);
		tabelaCobra.setSize(1000, 1000);
		tabelaCobra.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarCobra = new JScrollPane(tabelaCobra);
		scrollPaneListarCobra.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarCobra = new JPanel();
		panelListarCobra.setSize(1000, 1000);

		panelListarCobra.add(scrollPaneListarCobra);

		TextField caf = new TextField(10);
		panelListarCobra.add(caf);

		JButton botaoDeletar = new JButton("Deletar");
		panelListarCobra.add(botaoDeletar);

		frameDeletarCobra.add(panelListarCobra);
		frameDeletarCobra.setVisible(true);

		TelaDeletarCobraControlador telaDeletarCobraControlador = new TelaDeletarCobraControlador(caf,
				frameDeletarCobra);
		botaoDeletar.addActionListener(telaDeletarCobraControlador);

	}
}
