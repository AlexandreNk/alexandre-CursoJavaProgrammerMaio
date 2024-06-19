package tela;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCobraControlador;
import entidade.Cobra;
import enuns.CobraEnum;

public class TelaCadastroCobra {

	public void chamarTelaCadastroCobra() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome da Cobra";
		String segundoCampo = "Digite o CAF";
		String terceiroCampo = "Digite o tipo do veneno";
		String quartoCampo = "Digite o peso";

		JFrame frameTelaCadastroCobra = new JFrame();

		frameTelaCadastroCobra.setSize(200, 250);
		JPanel panelTelaCadastroCobra = new JPanel();

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);

		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroCobra.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoSegundoCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// Agora com caixa de selecao
		JComboBox<CobraEnum> caixaSelecaoTipoVeneno = new JComboBox<>(CobraEnum.values());
		panelTelaCadastroCobra.add(caixaSelecaoTipoVeneno);

		JTextField caixaTextoQuartoCampo = new JTextField(10);
		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroCobra.add(labelQuartoCampo);

		panelTelaCadastroCobra.setLayout(grid);

		JButton botaoCadastrar = new JButton("Cadastrar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);

		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);

		TelaCadastroCobraControlador cadastroCobraControlador = new TelaCadastroCobraControlador(
				caixaTextoPrimeiroCampo, caixaTextoSegundoCampo, caixaSelecaoTipoVeneno, frameTelaCadastroCobra,caixaTextoQuartoCampo);
		botaoCadastrar.addActionListener(cadastroCobraControlador);
	}

	public void imprimirCobra(List<Cobra> listaCobra) {

		StringBuilder impressaoCobraString = new StringBuilder();

		for (Cobra cobraItemLista : listaCobra) {
			impressaoCobraString.append("Nome: ").append(cobraItemLista.getNome()).append("\n").append("CAF: ")
					.append(cobraItemLista.getCAF()).append("\n").append("Cor Pelo: ")
					.append(cobraItemLista.getTipoVeneno()).append("\n").append("_____________________________")
					.append("\n");
		}

		JOptionPane.showMessageDialog(null, impressaoCobraString.toString());

	}
}
