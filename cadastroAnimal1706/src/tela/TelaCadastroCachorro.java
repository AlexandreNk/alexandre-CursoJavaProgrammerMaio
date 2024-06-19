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

import controlador.TelaCadastroCachorroControlador;
import entidade.Cachorro;
import enuns.CachorroEnum;

public class TelaCadastroCachorro {

	public void chamarTelaCadastroCachorro() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do cachorro";
		String segundoCampo = "Digite o CAF";
		String terceiroCampo = "Digite a cor do pelo";
		String quartoCampo = "Digite o peso";

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

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// Agora com caixa de selecao
		JComboBox<CachorroEnum> caixaSelecaoCor = new JComboBox<>(CachorroEnum.values());
		panelTelaCadastroCachorro.add(caixaSelecaoCor);


		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroCachorro.add(labelQuartoCampo);

		JTextField caixaTextoQuartoCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoQuartoCampo);
		
		panelTelaCadastroCachorro.setLayout(grid);

		JButton botaoCadastrar = new JButton("Cadastrar Cachorro");
		panelTelaCadastroCachorro.add(botaoCadastrar);

		frameTelaCadastroCachorro.add(panelTelaCadastroCachorro);
		frameTelaCadastroCachorro.setVisible(true);

		TelaCadastroCachorroControlador cadastroCachorroControlador = new TelaCadastroCachorroControlador(
				caixaTextoPrimeiroCampo, caixaTextoSegundoCampo, caixaSelecaoCor, frameTelaCadastroCachorro, caixaTextoQuartoCampo);
		botaoCadastrar.addActionListener(cadastroCachorroControlador);
	}

	public void imprimirCachorro(List<Cachorro> listaCachorros) {

		StringBuilder impressaoCachorroString = new StringBuilder();

		for (Cachorro cachorroItemLista : listaCachorros) {
			impressaoCachorroString.append("Nome: ").append(cachorroItemLista.getNome()).append("\n").append("CAF: ")
					.append(cachorroItemLista.getCAF()).append("\n").append("Cor Pelo: ")
					.append(cachorroItemLista.getCorPelo()).append("\n").append("_____________________________")
					.append("\n");
		}

		JOptionPane.showMessageDialog(null, impressaoCachorroString.toString());

	}
}
