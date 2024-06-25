package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlterarCachorroControlador;
import entidade.Cachorro;
import enuns.CachorroEnum;

public class TelaFormularioAlterarCachorro {

	public void chamarTelaCadastroCachorro(Cachorro cachorro) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Cachorro";
		String terceiroCampo = "Digite a cor do pelo do Cachorro";
		String quartoCampo = "Digite o peso";
		String ceplabel = "Digite o CEP";

		JFrame frameTelaCadastroCachorro = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroCachorro.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroCachorro = new JPanel();// Cria o objeto painel

		panelTelaCadastroCachorro.setLayout(grid);

		JLabel labelSegundoCampo = new JLabel("CAF: " + cachorro.getCAF()); // AQUI A GENTE APRESENTA O CAF DO CACHORRO
																			// SEM A OPÇÃO DE ALTERAR
		panelTelaCadastroCachorro.add(labelSegundoCampo);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCachorro.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(cachorro.getNome());// AQUI A GENTE COLOCA O NOME DO CACHORRO QUE VAI SER
															// ALTERADO
		panelTelaCadastroCachorro.add(caixaTextoPrimeiroCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCachorro.add(labelTerceiroCampo);

		/*
		 * JTextField caixaTextoTerceiroCampo = new JTextField(10);
		 * caixaTextoTerceiroCampo.setText(cachorro.getCorPelo());// AQUI A GENTE
		 * COLOCAR A COR DO PELO DO CACHORRO QUE VAI SER // ALTERADO
		 * panelTelaCadastroCachorro.add(caixaTextoTerceiroCampo);
		 */
		// Agora com caixa de selecao
		JComboBox<CachorroEnum> caixaSelecaoCor = new JComboBox<>(CachorroEnum.values());
		panelTelaCadastroCachorro.add(caixaSelecaoCor);

		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroCachorro.add(labelQuartoCampo);

		JTextField caixaTextoQuartoCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoQuartoCampo);

		JLabel jlabelCep = new JLabel(ceplabel);
		panelTelaCadastroCachorro.add(jlabelCep);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Alterar Cachorro");
		panelTelaCadastroCachorro.add(botaoCadastrar);

		frameTelaCadastroCachorro.add(panelTelaCadastroCachorro);
		frameTelaCadastroCachorro.setVisible(true);

		TelaFormularioAlterarCachorroControlador alterarCachorroControlador = new TelaFormularioAlterarCachorroControlador(
				caixaTextoPrimeiroCampo, cachorro.getCAF(), caixaSelecaoCor, caixaTextoQuartoCampo,
				frameTelaCadastroCachorro, caixaTextoCep);
		botaoCadastrar.addActionListener(alterarCachorroControlador);

	}
}
