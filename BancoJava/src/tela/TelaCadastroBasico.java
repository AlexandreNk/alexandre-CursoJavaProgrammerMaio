package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroBasicoControlador;

public class TelaCadastroBasico {

	public void chamarTelaCadastroBasico() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Correntista Basico";
		String segundoCampo = "Digite o cpf do Correntista";
		// String terceiroCampo = "Digite o tipo de cliente";
		String quartoCampo = "Digite a Quantidade de transações";
		String quintoCampo = "Digite o Limite de saque";
		String cepLabel = "Digite o CEP";

		JFrame frameTelaCadastroBasico = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroBasico.setSize(300, 250); // Altura e largura
		JPanel panelTelaCadastroBasico = new JPanel();// Cria o objeto painel

		panelTelaCadastroBasico.setLayout(grid);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroBasico.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoPrimeiroCampo);

		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroBasico.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoSegundoCampo);

		// JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		// panelTelaCadastroBasico.add(labelTerceiroCampo);

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// panelTelaCadastroBasico.add(caixaTextoTerceiroCampo);
		// Agora Vai ser uma caixa de seleção
		// JComboBox<TipoCorrentista> caixaSelecaoCorrentista = new
		// JComboBox<>(TipoCorrentista.values());
		// panelTelaCadastroBasico.add(caixaSelecaoCorrentista);

		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroBasico.add(labelQuartoCampo);

		JTextField caixaTextolabelQuartoCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextolabelQuartoCampo);

		JLabel labelQuintoCampo = new JLabel(quintoCampo);
		panelTelaCadastroBasico.add(labelQuintoCampo);

		JTextField caixaTextolabelQuintoCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextolabelQuintoCampo);

		JLabel jlabelCepLabel = new JLabel(cepLabel);
		panelTelaCadastroBasico.add(jlabelCepLabel);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Cadastrar Correntista Basico");
		panelTelaCadastroBasico.add(botaoCadastrar);

		frameTelaCadastroBasico.add(panelTelaCadastroBasico);
		frameTelaCadastroBasico.setVisible(true);

		TelaCadastroBasicoControlador basicoControlador = new TelaCadastroBasicoControlador(caixaTextoPrimeiroCampo,
				caixaTextoSegundoCampo, caixaTextolabelQuartoCampo, caixaTextolabelQuintoCampo,
				frameTelaCadastroBasico,
				caixaTextoCep);
		botaoCadastrar.addActionListener(basicoControlador);
	}

}
