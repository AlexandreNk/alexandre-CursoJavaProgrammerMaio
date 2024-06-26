package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaSelecionarAlterarBasicoControlador;
import entidade.Basico;

public class TelaSelecionarAlterarBasico {

	public void alterarBasico(List<Basico> listaBasicos) {

		int quantidadeDeLinhas = listaBasicos.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Basico basico : listaBasicos) {

			tabelaString[posicaoLinha][posicaoColuna] = basico.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = basico.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = basico.getLimiteDeSaque().toString();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "LIMITE_SAQUE" };

		JFrame framealterarBasicos = new JFrame();

		framealterarBasicos.setSize(475, 450);

		JTable tabelaBasicos = new JTable(tabelaString, nomeColunas);
		tabelaBasicos.setSize(1000, 1000);
		tabelaBasicos.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarBasico = new JScrollPane(tabelaBasicos);
		scrollPaneListarBasico.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarBasico = new JPanel();
		panelListarBasico.setSize(1000, 1000);

		panelListarBasico.add(scrollPaneListarBasico);

		JTextField cpf = new JTextField(10);
		panelListarBasico.add(cpf);

		JButton botaoalterar = new JButton("ALTERAR");
		panelListarBasico.add(botaoalterar);

		framealterarBasicos.add(panelListarBasico);
		framealterarBasicos.setVisible(true);

		TelaSelecionarAlterarBasicoControlador alterarBasicoControlador = new TelaSelecionarAlterarBasicoControlador(
				framealterarBasicos, cpf);
		botaoalterar.addActionListener(alterarBasicoControlador);
	}

}
