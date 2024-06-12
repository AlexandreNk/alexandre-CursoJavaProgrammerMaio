package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import repositorio.CachorroRepositorioImplementacao;
import tela.TelaFormularioAlterarCachorro;

public class TelaSelecionarAlterarCachorroControlador implements ActionListener {

	JTextField caf;
	JFrame jFrameTelaAlterar;

	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	TelaFormularioAlterarCachorro alterarCachorro = new TelaFormularioAlterarCachorro();

	public TelaSelecionarAlterarCachorroControlador(JTextField caf, JFrame jFrameTelaAlterar) {
		this.caf = caf;
		this.jFrameTelaAlterar = jFrameTelaAlterar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Cachorro cachorro = cachorroRepositorioImplementacao.buscaCachorroPorCaf(caf.getText());

		if (cachorro == null) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado o seguinte CAF: " + caf.getText());
		} else {
			jFrameTelaAlterar.setVisible(false);
			alterarCachorro.chamarTelaCadastroCachorro(cachorro);
		}

	}

}
