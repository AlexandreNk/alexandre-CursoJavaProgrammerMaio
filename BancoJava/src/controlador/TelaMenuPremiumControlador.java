package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.PremiumRepositorioImplementacao;
import tela.TelaCadastroPremium;
import tela.TelaDeletarPremium;
import tela.TelaListarPremium;
import tela.TelaSelecionarAlterarPremium;

public class TelaMenuPremiumControlador implements ActionListener {
	JTextField opcao;
	JFrame telaMenuPremium;

	public TelaMenuPremiumControlador(JTextField opcao, JFrame telaMenuPremium) {
		this.opcao = opcao;
		this.telaMenuPremium = telaMenuPremium;
	}

	TelaCadastroPremium telaCadastroPremium = new TelaCadastroPremium();
	TelaListarPremium telaListarPremium = new TelaListarPremium();
	TelaDeletarPremium telaPremium = new TelaDeletarPremium();
	TelaSelecionarAlterarPremium telaAlterarPremium = new TelaSelecionarAlterarPremium();
	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcao.getText().equals("P1") || opcao.getText().equals("P2") || opcao.getText().equals("P3")
				|| opcao.getText().equals("P4")) {
			switch (opcao.getText()) {
			case "P1": {
				telaMenuPremium.setVisible(false);
				telaCadastroPremium.chamarTelaCadastroPremium();
				break;
			}
			case "P2": {
				telaMenuPremium.setVisible(false);
				telaListarPremium.listarPremium(premiumRepositorioImplementacao.listarPremiumRepositorio());
				break;
			}
			case "P3": {
				telaMenuPremium.setVisible(false);
				telaPremium.deletarPremium(premiumRepositorioImplementacao.listarPremiumRepositorio());
				break;
			}
			case "P4": {
				telaMenuPremium.setVisible(false);
				telaAlterarPremium.alterarPremium(premiumRepositorioImplementacao.listarPremiumRepositorio());
				break;
			}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Opção Invalido");
		}

	}

}
