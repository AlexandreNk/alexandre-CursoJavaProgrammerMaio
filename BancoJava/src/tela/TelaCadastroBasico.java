package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroBasico {
	
	public void chamarTelaCadastroBasico() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Correntista Basico";
		String segundoCampo = "Digite o cpf do Correntista";
		String terceiroCampo = "Digite o tipo de cliente";
		String quartoCampo = "Digite a Quantidade de transações";
		String  cepLabel = "Digite o CEP";
		
		JFrame frameTelaCadastroBasico = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroBasico.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroBasico = new JPanel();// Cria o objeto painel

		
		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroBasico.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoSegundoCampo);
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroBasico.add(labelPrimeiroCampo);

		panelTelaCadastroBasico.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoPrimeiroCampo);

		

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroBasico.add(labelTerceiroCampo);

		//JTextField caixaTextoTerceiroCampo = new JTextField(10);
		//panelTelaCadastroBasico.add(caixaTextoTerceiroCampo);
		// Agora Vai ser uma caixa de seleção
		JComboBox<CorrentistaEnum> caixaSelecaoCorrentista = new JComboBox<>(CorrentistaEnum.values());
		panelTelaCadastroBasico.add(caixaSelecaoCorrentista);
		
		
		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroBasico.add(labelQuartoCampo);

		JTextField caixaTextolabelQuartoCampo = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextolabelQuartoCampo);
		
		JLabel jlabelCepLabel = new JLabel(cepLabel);
		panelTelaCadastroBasico.add(jlabelCepLabel);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroBasico.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Cadastrar Basico");
		panelTelaCadastroBasico.add(botaoCadastrar);

		frameTelaCadastroBasico.add(panelTelaCadastroBasico);
		frameTelaCadastroBasico.setVisible(true);

		TelaCadastroBasicoControlador basicoControlador = new TelaCadastroBasicoControlador(
				caixaTextoPrimeiroCampo, caixaTextoSegundoCampo, caixaSelecaoCorrentista, frameTelaCadastroBasico, caixaTextolabelQuartoCampo, caixaTextoCep );
		botaoCadastrar.addActionListener(basicoControlador);
	}
	}

}
