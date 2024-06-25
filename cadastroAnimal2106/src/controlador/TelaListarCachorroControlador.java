package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repositorio.CachorroRepositorioImplementacao;
import service.EntidadeService;
import tela.TelaMenuCachorro;

public class TelaListarCachorroControlador implements ActionListener {
	
	JFrame telaListar;
	JTextField jTextFieldCaf;

	public TelaListarCachorroControlador(JFrame telaListar, JTextField jTextFieldCaf) {
		this.telaListar = telaListar;
		this.jTextFieldCaf = jTextFieldCaf;
	}
	

	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	EntidadeService entidadeService = new EntidadeService();
	
	TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="MENU") {
			telaListar.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();
		}
		if(e.getActionCommand()=="DETALHAR") {
			entidadeService.gerarPdfDetalharCachorro(cachorroRepositorioImplementacao.buscaCachorroPorCaf(jTextFieldCaf.getText()));
		}
		
	}
	
	

}
