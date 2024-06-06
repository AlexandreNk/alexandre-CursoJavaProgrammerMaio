package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuInicialControlador;

public class TelaMenuInicial {

	public void chamarTelaMenuIniciar() {
		
		JFrame frameTelaMenuInicial = new JFrame();
		
		frameTelaMenuInicial.setSize(200,200);
		
		JPanel panelTelaInicial = new JPanel();
		
		JLabel labelOpcaoCachorro = new JLabel(" 1 - Cachorro ");
		panelTelaInicial.add(labelOpcaoCachorro);
		
		JLabel labelOpcaoCobra = new JLabel(" 2 - Cobra ");
		panelTelaInicial.add(labelOpcaoCobra);
		
		JTextField opcaoTexto = new JTextField(10);
		panelTelaInicial.add(opcaoTexto);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaInicial.add(botaoEnviar);
		
		frameTelaMenuInicial.add(panelTelaInicial);
		frameTelaMenuInicial.setVisible(true);
		
		TelaMenuInicialControlador telaMenuInicialControlador = new TelaMenuInicialControlador(opcaoTexto);
		botaoEnviar.addActionListener(telaMenuInicialControlador);
		
	}
	
}
