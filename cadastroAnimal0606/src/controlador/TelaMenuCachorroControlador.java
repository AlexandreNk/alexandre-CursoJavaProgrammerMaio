package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import persistencia.DaoCachorro;
import tela.TelaCadastroCachorro;

public class TelaMenuCachorroControlador implements ActionListener {
	
	JTextField opcaoRecebida;
	JFrame frameTelaMenuCachorro;
	
	TelaCadastroCachorro cadastroCachorro = new TelaCadastroCachorro();
	DaoCachorro daoCachorro = new DaoCachorro();
	List<Cachorro> listCachorro = new ArrayList<Cachorro>();


	public TelaMenuCachorroControlador(JTextField opcaoRecebida, JFrame frameTelaMenuCachorro) {
		super();
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCachorro = frameTelaMenuCachorro;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2")) {
			switch (opcaoRecebida.getText()){
			case "G1" : {
				cadastroCachorro.chamarTelaCadastroCachorro();
				System.out.println("Direcione para cadastro de cachorros");
				frameTelaMenuCachorro.setVisible(false);
				break;
			}
			case "G2" : {
				cadastroCachorro.imprimirCachorro(daoCachorro.retornaListaCachorros());
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
