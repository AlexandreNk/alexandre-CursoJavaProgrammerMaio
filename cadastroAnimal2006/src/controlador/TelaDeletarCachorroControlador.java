package controlador;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.CachorroRepositorioImplementacao;
import tela.TelaMenuCachorro;

public class TelaDeletarCachorroControlador implements ActionListener	{

	TextField cafRecebido;
	JFrame frameDeletar;
	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	
	TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();
	
	public TelaDeletarCachorroControlador(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(cachorroRepositorioImplementacao.excluirCachorroRepositorio(cafRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "O cachorro de Caf " +cafRecebido.getText()+ " Foi deletado");
			frameDeletar.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();
			
		}
		if(e.getActionCommand().equals("MENU")) {
			frameDeletar.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();
		}

		/*else {
			JOptionPane.showMessageDialog(null, "O cachorro de Caf " +cafRecebido.getText()+ " Não foi deletado");
		}*/
		
		
	}

}
