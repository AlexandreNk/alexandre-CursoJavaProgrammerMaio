package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlterarCobraControlador;
import entidade.Cobra;

public class TelaFormularioAlterarCobra {

	public void chamarTelaCadastroCobra(Cobra cobra) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome da Cobra";
		String terceiroCampo = "Digite o tipo de veneno da Cobra";

		JFrame frameTelaCadastroCobra = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroCobra.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroCobra = new JPanel();// Cria o objeto painel

		JLabel labelSegundoCampo = new JLabel("CAF: " + cobra.getCAF()); // AQUI A GENTE APRESENTA O CPF DO GERENTE
																			// SEM A OPÇÃO DE ALTERAR
		panelTelaCadastroCobra.add(labelSegundoCampo);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);

		panelTelaCadastroCobra.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(cobra.getNome());// AQUI A GENTE COLOCA O NOME DO GERENTE QUE VAI SER ALTERADO
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);

		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		caixaTextoTerceiroCampo.setText(cobra.getTipoVeneno());// AQUI A GENTE COLOCAR A GERENCIA DO GERENTE QUE VAI SER
																// ALTERADO
		panelTelaCadastroCobra.add(caixaTextoTerceiroCampo);

		JButton botaoCadastrar = new JButton("Alterar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);

		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);

		TelaFormularioAlterarCobraControlador alterarCobraControlador = new TelaFormularioAlterarCobraControlador(
				caixaTextoPrimeiroCampo, cobra.getCAF(), caixaTextoTerceiroCampo, frameTelaCadastroCobra);
		botaoCadastrar.addActionListener(alterarCobraControlador);

	}
}
