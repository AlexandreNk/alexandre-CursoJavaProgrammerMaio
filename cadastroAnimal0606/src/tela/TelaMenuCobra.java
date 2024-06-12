package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuCobraControlador;

public class TelaMenuCobra {
	
	public void chamarTelaMenuCobra() {
		
		GridLayout grid = new GridLayout(0,1);
		
		JFrame frameTelaMenuCobra = new JFrame();
				
		frameTelaMenuCobra.setSize(200,200);
		
		JPanel panelTelaCobra = new JPanel();
		
		JLabel labelOpcaoCadastrarCobra = new JLabel(" G1 - Cadastrar Cobra ");
		panelTelaCobra.add(labelOpcaoCadastrarCobra);
		
		JLabel labelOpcaoListarCobra = new JLabel(" G2 - Listar Cobra ");
		panelTelaCobra.add(labelOpcaoListarCobra);
		
		JLabel labelOpcaoDeletarCobra = new JLabel(" G3 - Deletar Cobra ");
		panelTelaCobra.add(labelOpcaoDeletarCobra);
		
		panelTelaCobra.setLayout(grid);
		
		JTextField opcaoTexto = new JTextField(10);
		panelTelaCobra.add(opcaoTexto);
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaCobra.add(botaoEnviar);
		
		frameTelaMenuCobra.add(panelTelaCobra);
		frameTelaMenuCobra.setVisible(true);

		TelaMenuCobraControlador telaMenuCobraControlador = new TelaMenuCobraControlador(opcaoTexto,frameTelaMenuCobra);
		botaoEnviar.addActionListener(telaMenuCobraControlador);

		
	}
}
