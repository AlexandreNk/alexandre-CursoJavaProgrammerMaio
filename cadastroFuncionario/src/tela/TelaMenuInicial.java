package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaMenuInicial {

		public void chamarTelaMenuIniciar() {
			
			JFrame frameTelaInicial = new JFrame(); //instanciando um JFrame
			
			frameTelaInicial.setSize(200,200);//altura e largura
			
			JPanel panelTelaInicial = new JPanel(); // cria o objeto painel
			
			JLabel labelOpcaoGerente = new JLabel(" 1 - MENU GERENTE"); //cria o label 1
			panelTelaInicial.add(labelOpcaoGerente);	//adiciona a label no painel

			JLabel labelOpcaoAtendente = new JLabel(" 1 - MENU ATENDENTE"); //cria o label 1
			panelTelaInicial.add(labelOpcaoAtendente);	//adiciona a label no painel

			JTextField opcaoTexto = new JTextField(10);
			panelTelaInicial.add(opcaoTexto);
			
			JButton botaoEnviar = new JButton("Enviar");
			panelTelaInicial.add(botaoEnviar);
			
			frameTelaInicial.add(panelTelaInicial); //adiciona o painel no frame			
			frameTelaInicial.setVisible(true); //deixa visivel
			
		}
}
