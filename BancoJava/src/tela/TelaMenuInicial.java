package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuInicialControlador;

public class TelaMenuInicial {

	public void chamarTelaMenuIniciar() {

		JFrame frameTelaInicial = new JFrame();// Instanciando um JFrame Vazio

		GridLayout grid = new GridLayout(0, 1);

		frameTelaInicial.setSize(250, 250); // Altura e largura
		JPanel panelTelaInicial = new JPanel();// Cria o objeto painel

		JLabel labelOpcaoGerente = new JLabel(" 1 - MENU CORRENTISTA BASICO");// Cria a label 1
		panelTelaInicial.add(labelOpcaoGerente);// Adiciona a label 1 no painel

		JLabel labelOpcaoAtendente = new JLabel(" 2 - MENU CORRENTISTA PREMIUM");// Cria a label 1
		panelTelaInicial.add(labelOpcaoAtendente);// Adiciona a label 1 no painel
		panelTelaInicial.setLayout(grid);

		JTextField opcaoTexto = new JTextField(10);// Caixa de texto

		panelTelaInicial.add(opcaoTexto);// add o que foi digitado

		JButton botaoEnviar = new JButton("Enviar");
		panelTelaInicial.add(botaoEnviar);

		frameTelaInicial.add(panelTelaInicial);// Adiciona o painel no frame
		frameTelaInicial.setVisible(true);// Deixa visivel

		TelaMenuInicialControlador telaMenuInicialControlador = new TelaMenuInicialControlador(opcaoTexto,
				frameTelaInicial);
		// Alo construir o controlador o mesmo vai ter o valor opcaoTexto inserido
		botaoEnviar.addActionListener(telaMenuInicialControlador);

	}
}
