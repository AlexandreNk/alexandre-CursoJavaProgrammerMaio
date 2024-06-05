package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TelaMenuInicialControlador implements ActionListener{

	JTextField opcao;
	
	public TelaMenuInicialControlador(JTextField opcao) {
		
		this.opcao = opcao;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcao.getText()) {
		
		case "1" : {
				System.out.println("Direcione para a tela gerente");
				break;
		}
		case "2" : {
			System.out.println("Direcione para a tela de atendente");
			break;
		}
		case "3" : {
			System.exit(0);
			break;
		}
		
		}
		
	}
	
	

}
