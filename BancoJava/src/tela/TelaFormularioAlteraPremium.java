package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlteraPremiumControlador;
import entidade.Premium;

public class TelaFormularioAlteraPremium {

	public void chamarTelaCadastroPremium(Premium premium) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Premium";
		String quintoCampo = "Digite o limite de credito do Correntista Premium";

		JFrame frameTelaCadastroPremium = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroPremium.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroPremium = new JPanel();// Cria o objeto painel

		panelTelaCadastroPremium.setLayout(grid);

		JLabel labelCpf = new JLabel("CPF:" + premium.getCpf());
		panelTelaCadastroPremium.add(labelCpf);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroPremium.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(premium.getNome());
		panelTelaCadastroPremium.add(caixaTextoPrimeiroCampo);

		JLabel labelQuintoCampo = new JLabel(quintoCampo);
		panelTelaCadastroPremium.add(labelQuintoCampo);

		JTextField caixaTextoQuintoCampo = new JTextField(10);
		caixaTextoQuintoCampo.setText(premium.getLimiteCredito().toString());
		panelTelaCadastroPremium.add(caixaTextoQuintoCampo);

		// JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		// panelTelaCadastroPremium.add(labelTerceiroCampo);

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// caixaTextoTerceiroCampo.setText(premium.getSetor());
		// panelTelaCadastroPremium.add(caixaTextoTerceiroCampo);

		JButton botaoAlterar = new JButton("Alterar Premium");
		panelTelaCadastroPremium.add(botaoAlterar);

		frameTelaCadastroPremium.add(panelTelaCadastroPremium);
		frameTelaCadastroPremium.setVisible(true);

		TelaFormularioAlteraPremiumControlador alteraPremiumControlador = new TelaFormularioAlteraPremiumControlador(
				caixaTextoPrimeiroCampo, quintoCampo, caixaTextoPrimeiroCampo, frameTelaCadastroPremium);
		botaoAlterar.addActionListener(alteraPremiumControlador);

	}
}
