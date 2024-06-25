package tela;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.TelaDeletarCachorroControlador;
import entidade.Cachorro;

public class TelaDeletarCachorro {

	public void chamarTelaDeletarCachorro(List<Cachorro> listaCachorro) {

		int quantidadeDeLinhas = listaCachorro.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Cachorro cachorro : listaCachorro) {

			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getCAF();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getCorPelo();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CAF", "NOME", "CORPELO" };

		JFrame frameDeletarCachorro = new JFrame();

		frameDeletarCachorro.setSize(475, 450);

		JTable tabelaCachorro = new JTable(tabelaString, nomeColunas);
		tabelaCachorro.setSize(1000, 1000);
		tabelaCachorro.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarCachorro = new JScrollPane(tabelaCachorro);
		scrollPaneListarCachorro.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarCachorro = new JPanel();
		panelListarCachorro.setSize(1000, 1000);

		panelListarCachorro.add(scrollPaneListarCachorro);

		TextField caf = new TextField(10);
		panelListarCachorro.add(caf);

		JButton botaoDeletar = new JButton("Deletar");
		panelListarCachorro.add(botaoDeletar);

		frameDeletarCachorro.add(panelListarCachorro);
		frameDeletarCachorro.setVisible(true);

		TelaDeletarCachorroControlador telaDeletarCachorroControlador = new TelaDeletarCachorroControlador(caf,
				frameDeletarCachorro);
		botaoDeletar.addActionListener(telaDeletarCachorroControlador);

	}
}
