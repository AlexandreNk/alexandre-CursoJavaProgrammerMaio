package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCachorroControlador;
import controlador.TelaMenuCachorroControlador;

public class TelaMenuCachorro {
	
	public void chamarTelaMenuCachorro() {
		
		JFrame frameTelaMenuCachorro = new JFrame();
		
		frameTelaMenuCachorro.setSize(200,200);
		
		JPanel panelTelaCachorro = new JPanel();
		
		JLabel labelOpcaoCadastrarCachorro = new JLabel(" G1 - Cadastrar Cachorro ");
		panelTelaCachorro.add(labelOpcaoCadastrarCachorro);
		
		JLabel labelOpcaoListarCachorro = new JLabel(" G2 - Listar Cachorro ");
		panelTelaCachorro.add(labelOpcaoListarCachorro);
		
		JTextField opcaoTexto = new JTextField(10);
		panelTelaCachorro.add(opcaoTexto);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaCachorro.add(botaoEnviar);
		
		frameTelaMenuCachorro.add(panelTelaCachorro);
		frameTelaMenuCachorro.setVisible(true);
		
		TelaMenuCachorroControlador telaMenuCachorroControlador = new TelaMenuCachorroControlador(opcaoTexto);
		botaoEnviar.addActionListener(telaMenuCachorroControlador);
	}
}
