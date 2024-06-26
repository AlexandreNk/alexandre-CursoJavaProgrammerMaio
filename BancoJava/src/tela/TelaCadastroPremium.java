package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroPremiumControlador;

public class TelaCadastroPremium {

	public void chamarTelaCadastroPremium() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Correntista Premium";
		String segundoCampo = "Digite o cpf do Correntista";
		// String terceiroCampo = "Digite o tipo de cliente";
		String quartoCampo = "Digite a Quantidade de transações";
		String quintoCampo = "Digite o Limite de Credito";
		String cepLabel = "Digite o CEP";

		JFrame frameTelaCadastroPremium = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroPremium.setSize(300, 250); // Altura e largura
		JPanel panelTelaCadastroPremium = new JPanel();// Cria o objeto painel

		panelTelaCadastroPremium.setLayout(grid);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroPremium.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroPremium.add(caixaTextoPrimeiroCampo);

		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroPremium.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroPremium.add(caixaTextoSegundoCampo);

		// JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		// panelTelaCadastroPremium.add(labelTerceiroCampo);

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// panelTelaCadastroPremium.add(caixaTextoTerceiroCampo);
		// Agora Vai ser uma caixa de seleção
		// JComboBox<TipoCorrentista> caixaSelecaoCorrentista = new
		// JComboBox<>(TipoCorrentista.values());
		// panelTelaCadastroPremium.add(caixaSelecaoCorrentista);

		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroPremium.add(labelQuartoCampo);

		JTextField caixaTextolabelQuartoCampo = new JTextField(10);
		panelTelaCadastroPremium.add(caixaTextolabelQuartoCampo);

		JLabel labelQuintoCampo = new JLabel(quintoCampo);
		panelTelaCadastroPremium.add(labelQuintoCampo);

		JTextField caixaTextolabelQuintoCampo = new JTextField(10);
		panelTelaCadastroPremium.add(caixaTextolabelQuintoCampo);

		JLabel jlabelCepLabel = new JLabel(cepLabel);
		panelTelaCadastroPremium.add(jlabelCepLabel);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroPremium.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Cadastrar Correntista Premium");
		panelTelaCadastroPremium.add(botaoCadastrar);

		frameTelaCadastroPremium.add(panelTelaCadastroPremium);
		frameTelaCadastroPremium.setVisible(true);

		TelaCadastroPremiumControlador premiumControlador = new TelaCadastroPremiumControlador(caixaTextoPrimeiroCampo,
				caixaTextoSegundoCampo, caixaTextolabelQuartoCampo, caixaTextolabelQuintoCampo,
				frameTelaCadastroPremium, caixaTextoCep);
		botaoCadastrar.addActionListener(premiumControlador);
	}

}
