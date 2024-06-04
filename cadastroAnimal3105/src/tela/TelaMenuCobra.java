package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaMenuCobra {
	
	public void chamarTelaMenuCobra() {
		
		JFrame frameTelaMenuCobra = new JFrame();
		
		frameTelaMenuCobra.setSize(200,200);
		
		JPanel panelTelaCobra = new JPanel();
		
		JLabel labelOpcaoCadastrarCobra = new JLabel(" 1 - Cadastrar Cobra ");
		panelTelaCobra.add(labelOpcaoCadastrarCobra);
		
		JLabel labelOpcaoListarCobra = new JLabel(" 2 - Listar Cobra ");
		panelTelaCobra.add(labelOpcaoListarCobra);
		
		JTextField opcaoTexto = new JTextField(10);
		panelTelaCobra.add(opcaoTexto);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaCobra.add(botaoEnviar);
		
		frameTelaMenuCobra.add(panelTelaCobra);
		frameTelaMenuCobra.setVisible(true);
		
		
	}
}
