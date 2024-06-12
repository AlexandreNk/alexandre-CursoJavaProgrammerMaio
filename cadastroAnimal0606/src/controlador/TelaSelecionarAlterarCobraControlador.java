package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaFormularioAlterarCobra;

public class TelaSelecionarAlterarCobraControlador implements ActionListener{

	JTextField caf;
	JFrame jFrameTelaAlterar;

	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaFormularioAlterarCobra alterarCobra = new TelaFormularioAlterarCobra();

	public TelaSelecionarAlterarCobraControlador(JTextField caf, JFrame jFrameTelaAlterar) {
		this.caf = caf;
		this.jFrameTelaAlterar = jFrameTelaAlterar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Cobra cobra = cobraRepositorioImplementacao.buscaCobraPorCaf(caf.getText());

		if (cobra == null) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado o seguinte CAF: " + caf.getText());
		} else {
			jFrameTelaAlterar.setVisible(false);
			alterarCobra.chamarTelaCadastroCobra(cobra);
		}
		
	}

}
