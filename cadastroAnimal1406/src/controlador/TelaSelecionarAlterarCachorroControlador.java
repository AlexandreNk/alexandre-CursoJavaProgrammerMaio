package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import repositorio.CachorroRepositorioImplementacao;
import tela.TelaFormularioAlterarCachorro;
import tela.TelaMenuCachorro;

public class TelaSelecionarAlterarCachorroControlador implements ActionListener {

	JTextField caf;
	JFrame jFrameTelaAlterar;

	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	TelaFormularioAlterarCachorro alterarCachorro = new TelaFormularioAlterarCachorro();
	TelaMenuCachorro telaCachorro = new TelaMenuCachorro();

	public TelaSelecionarAlterarCachorroControlador(JTextField caf, JFrame jFrameTelaAlterar) {
		this.caf = caf;
		this.jFrameTelaAlterar = jFrameTelaAlterar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getActionCommand().equals("Alterar")) {
			System.out.println("Ir para alterar");
			Cachorro cachorro = cachorroRepositorioImplementacao.buscaCachorroPorCaf(caf.getText());
			
			if (cachorro != null) {
				alterarCachorro.chamarTelaCadastroCachorro(cachorro);
				jFrameTelaAlterar.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Não foi encontrado o seguinte CAF: " + caf.getText());
			}
		}

		if (e.getActionCommand().equals("Menu")) {
			System.out.println("Voltar para o menu");
			telaCachorro.chamarTelaMenuCachorro();
			jFrameTelaAlterar.setVisible(false);
		}

		/*
		 * else { jFrameTelaAlterar.setVisible(false);
		 * alterarCachorro.chamarTelaCadastroCachorro(cachorro); }
		 */

	}

}
