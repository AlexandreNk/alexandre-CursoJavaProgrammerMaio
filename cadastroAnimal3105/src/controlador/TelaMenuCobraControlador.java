package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaCadastroCobra;

public class TelaMenuCobraControlador implements ActionListener {
	
	JTextField opcaoRecebida;
	
	TelaCadastroCobra cadastroCobra= new TelaCadastroCobra();
	
	public TelaMenuCobraControlador(JTextField opcaoRecebida) {
		this.opcaoRecebida = opcaoRecebida;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2")) {
			switch (opcaoRecebida.getText()){
			case "G1" : {
				cadastroCobra.chamarTelaCadastroCobra();
				System.out.println("Direcione para cadastro de cobras");
				break;
			}
			case "G2" : {
				System.out.println("Direcione para lista de cobras");
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
