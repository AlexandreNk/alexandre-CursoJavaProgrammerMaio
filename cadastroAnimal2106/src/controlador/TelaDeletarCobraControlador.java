package controlador;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaDeletarCobraControlador implements ActionListener{

	TextField cafRecebido;
	JFrame frameDeletar;
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
	
	public TelaDeletarCobraControlador(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(cobraRepositorioImplementacao.excluirCobraRepositorio(cafRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "A cobra de Caf " +cafRecebido.getText()+ " Foi deletado");
			frameDeletar.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
			
		}
		if(e.getActionCommand().equals("MENU")) {
			frameDeletar.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
		}
		/*else {
			JOptionPane.showMessageDialog(null, "A cobra de Caf " +cafRecebido.getText()+ " Não foi deletado");
		}*/
		
	}
	

}
