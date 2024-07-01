package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Premium;
import repositorio.PremiumRepositorioImplementacao;
import tela.TelaFormularioAlteraPremium;
import tela.TelaMenuPremium;

public class TelaSelecionarAlterarPremiumControlador implements ActionListener {

	JFrame telaListarAlterar;
	JTextField cpf;

	public TelaSelecionarAlterarPremiumControlador(JFrame telaListarAlterar, JTextField cpf) {

		this.telaListarAlterar = telaListarAlterar;
		this.cpf = cpf;
	}

	TelaMenuPremium telaPremium = new TelaMenuPremium();
	TelaFormularioAlteraPremium formularioAlteraPremium = new TelaFormularioAlteraPremium();
	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ALTERAR")) {

			System.out.println("ir para alterar correntista premium");
			Premium premium = premiumRepositorioImplementacao.buscaPremiumPorCpf(cpf.getText());

			if (premium != null) {
				formularioAlteraPremium.chamarTelaCadastroPremium(premium);
				telaListarAlterar.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "O CPF " + cpf.getText() + " Não foi Encontrado!!");
			}

		}

		if (e.getActionCommand().equals("MENU")) {
			System.out.println("Voltar para o menu");
			telaPremium.chamarTelaMenuPremium();
			telaListarAlterar.setVisible(false);

		}

	}

}
