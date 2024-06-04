package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaCadastroCachorro;

public class TelaMenuCachorroControlador implements ActionListener {
	
	JTextField opcaoRecebida;
	
	TelaCadastroCachorro cadastroCachorro = new TelaCadastroCachorro();
	
	public TelaMenuCachorroControlador(JTextField opcaoRecebida) {
		this.opcaoRecebida = opcaoRecebida;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2")) {
			switch (opcaoRecebida.getText()){
			case "G1" : {
				cadastroCachorro.chamarTelaCadastroCachorro();
				System.out.println("Direcione para cadastro de cachorros");
				break;
			}
			case "G2" : {
				System.out.println("Direcione para lista de cachorros");
				break;
			}
			case "3" :{
				System.exit(0);
				break;		
			}
				
			}
		}else {
			JOptionPane.showMessageDialog(null,"A opção " + opcaoRecebida.getText()+" não é válida");
		}
		
	}
	
}
