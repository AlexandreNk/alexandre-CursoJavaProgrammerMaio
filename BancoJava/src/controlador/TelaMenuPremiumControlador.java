package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaMenuPremiumControlador implements ActionListener {
	JTextField opcao;
	JFrame telaMenuPremium;

	public TelaMenuPremiumControlador(JTextField opcao, JFrame telaMenuPremium) {
		this.opcao = opcao;
		this.telaMenuPremium = telaMenuPremium;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcao.getText().equals("P1") || opcao.getText().equals("P2") || opcao.getText().equals("P3")
				|| opcao.getText().equals("P4")) {
			switch (opcao.getText()) {
			case "B1": {
				telaMenuPremium.setVisible(false);
				// telaCadastroPremium.chamarTelaCadastroPremium();
				break;
			}
			case "B2": {
				telaMenuPremium.setVisible(false);
				// telaListarPremium.listarPremium(premiumRepositorioImplemetacao.listarPremiumRepositorio());
				break;
			}
			case "B3": {
				telaMenuPremium.setVisible(false);
				// telaPremium.deletarPremium(premiumRepositorioImplemetacao.listarPremiumRepositorio());
				break;
			}
			case "B4": {
				telaMenuPremium.setVisible(false);
				// telaAlterarPremium.alterarPremium(premiumRepositorioImplemetacao.listarPremiumRepositorio());
				break;
			}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Opção Invalido");
		}

	}

}
