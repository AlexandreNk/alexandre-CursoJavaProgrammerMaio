package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlterarCobraControlador;
import entidade.Cobra;
import enuns.CobraEnum;

public class TelaFormularioAlterarCobra {

	public void chamarTelaCadastroCobra(Cobra cobra) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome da Cobra";
		String terceiroCampo = "Digite o tipo de veneno da Cobra";
		String quartoCampo = "Digite o peso";
		String ceplabel = "Digite o CEP";

		JFrame frameTelaCadastroCobra = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroCobra.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroCobra = new JPanel();// Cria o objeto painel

		panelTelaCadastroCobra.setLayout(grid);

		JLabel labelSegundoCampo = new JLabel("CAF: " + cobra.getCAF()); // AQUI A GENTE APRESENTA O CPF DO GERENTE
																			// SEM A OPÇÃO DE ALTERAR
		panelTelaCadastroCobra.add(labelSegundoCampo);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(cobra.getNome());// AQUI A GENTE COLOCA O NOME DO GERENTE QUE VAI SER ALTERADO
															// ALTERADO
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);

		/*
		 * JTextField caixaTextoTerceiroCampo = new JTextField(10);
		 * caixaTextoTerceiroCampo.setText(cobra.getTipoVeneno());// AQUI A GENTE
		 * COLOCAR A GERENCIA DO GERENTE QUE VAI SER
		 *
		 * panelTelaCadastroCobra.add(caixaTextoTerceiroCampo);
		 */
		// Agora com caixa de selecao
		JComboBox<CobraEnum> caixaSelecaoTipoVeneno = new JComboBox<>(CobraEnum.values());
		panelTelaCadastroCobra.add(caixaSelecaoTipoVeneno);

		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroCobra.add(labelQuartoCampo);

		JTextField caixaTextoQuartoCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoQuartoCampo);

		JLabel jlabelCep = new JLabel(ceplabel);
		panelTelaCadastroCobra.add(jlabelCep);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Alterar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);

		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);

		TelaFormularioAlterarCobraControlador alterarCobraControlador = new TelaFormularioAlterarCobraControlador(
				caixaTextoPrimeiroCampo, cobra.getCAF(), caixaSelecaoTipoVeneno, caixaTextoQuartoCampo, frameTelaCadastroCobra,
				caixaTextoCep);
		botaoCadastrar.addActionListener(alterarCobraControlador);

	}
}
