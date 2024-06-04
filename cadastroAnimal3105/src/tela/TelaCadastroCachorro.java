package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCachorroControlador;

public class TelaCadastroCachorro {

	public void chamarTelaCadastroCachorro() {

		String primeiroCampo = "Digite o nome do cachorro";
		String segundoCampo = "Digite o CAF";
		String terceiroCampo = "Digite a cor do pelo";

		JFrame frameTelaCadastroCachorro = new JFrame();

		frameTelaCadastroCachorro.setSize(200, 250);
		JPanel panelTelaCadastroCachorro = new JPanel();

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCachorro.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoPrimeiroCampo);

		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroCachorro.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoSegundoCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCachorro.add(labelTerceiroCampo);

		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoTerceiroCampo);

		JButton botaoCadastrar = new JButton("Cadastrar Cachorro");
		panelTelaCadastroCachorro.add(botaoCadastrar);

		frameTelaCadastroCachorro.add(panelTelaCadastroCachorro);
		frameTelaCadastroCachorro.setVisible(true);

		TelaCadastroCachorroControlador cadastroCachorroControlador = new TelaCadastroCachorroControlador(caixaTextoPrimeiroCampo,
				caixaTextoSegundoCampo, caixaTextoTerceiroCampo);
		botaoCadastrar.addActionListener(cadastroCachorroControlador);
	}
}
