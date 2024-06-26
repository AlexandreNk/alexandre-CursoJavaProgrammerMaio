package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaDeletarBasicoControlador;
import entidade.Basico;

public class TelaDeletarBasico {

	public void deletarBasico(List<Basico> listaBasicos) {

		int quantidadeDeLinhas = listaBasicos.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Basico basico : listaBasicos) {

			tabelaString[posicaoLinha][posicaoColuna] = basico.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = basico.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = basico.getValorDaAnuidade().toString();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "VALOR_ANUIDADE" };

		JFrame frameListarBasico = new JFrame();

		frameListarBasico.setSize(475, 450);

		JTable tabelaBasicos = new JTable(tabelaString, nomeColunas);
		tabelaBasicos.setSize(1000, 1000);
		tabelaBasicos.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarBasico = new JScrollPane(tabelaBasicos);
		scrollPaneListarBasico.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarBasico = new JPanel();
		panelListarBasico.setSize(1000, 1000);
		JButton botaoMenu = new JButton("MENU");

		JButton botaoDeletar = new JButton("DELETAR");

		JTextField cpfTextField = new JTextField(10);

		panelListarBasico.add(cpfTextField);
		panelListarBasico.add(botaoDeletar);

		panelListarBasico.add(scrollPaneListarBasico);
		panelListarBasico.add(botaoMenu);
		frameListarBasico.add(panelListarBasico);
		frameListarBasico.setVisible(true);

		TelaDeletarBasicoControlador telaDeletarBasicoControlador = new TelaDeletarBasicoControlador(frameListarBasico,
				cpfTextField);
		botaoMenu.addActionListener(telaDeletarBasicoControlador);
		botaoDeletar.addActionListener(telaDeletarBasicoControlador);

	}
}
