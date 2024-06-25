package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repositorio.CobraRepositorioImplementacao;
import service.EntidadeService;
import tela.TelaMenuCobra;

public class TelaListarCobraControlador implements ActionListener {

	JFrame telaListar;
	JTextField jTextFieldCaf;

	
	public TelaListarCobraControlador(JFrame telaListar, JTextField jTextFieldCaf) {
		this.telaListar = telaListar;
		this.jTextFieldCaf = jTextFieldCaf;
	}

	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	EntidadeService entidadeService = new EntidadeService();
	
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="MENU") {
			telaListar.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
		}
		if(e.getActionCommand()=="DETALHAR") {
			entidadeService.gerarPdfDetalharCobra(cobraRepositorioImplementacao.buscaCobraPorCaf(jTextFieldCaf.getText()));
		}
		
	}
}
