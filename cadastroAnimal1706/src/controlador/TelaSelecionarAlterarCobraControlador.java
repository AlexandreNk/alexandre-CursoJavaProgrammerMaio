package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaFormularioAlterarCobra;
import tela.TelaMenuCobra;

public class TelaSelecionarAlterarCobraControlador implements ActionListener{

	JTextField caf;
	JFrame jFrameTelaAlterar;

	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaFormularioAlterarCobra alterarCobra = new TelaFormularioAlterarCobra();
	TelaMenuCobra telaCobra = new TelaMenuCobra();
	
	public TelaSelecionarAlterarCobraControlador(JTextField caf, JFrame jFrameTelaAlterar) {
		this.caf = caf;
		this.jFrameTelaAlterar = jFrameTelaAlterar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().equals("Alterar")) {
			System.out.println("Ir para alterar");
			Cobra cobra = cobraRepositorioImplementacao.buscaCobraPorCaf(caf.getText());
			
			if (cobra != null) {
				alterarCobra.chamarTelaCadastroCobra(cobra);
				jFrameTelaAlterar.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Não foi encontrado o seguinte CAF: " + caf.getText());
			}
		}

		if (e.getActionCommand().equals("Menu")) {
			System.out.println("Voltar para o menu");
			telaCobra.chamarTelaMenuCobra();
			jFrameTelaAlterar.setVisible(false);
		}

		/*
		 * else { jFrameTelaAlterar.setVisible(false);
		 * alterarCobra.chamarTelaCadastroCobra(cobra); }
		 */

	}

}
