package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.PremiumRepositorioImplementacao;
import tela.TelaMenuPremium;

public class TelaDeletarPremiumControlador implements ActionListener {

	JFrame telaDeletarPremium;
	JTextField cpf;

	public TelaDeletarPremiumControlador(JFrame telaDeletarPremium, JTextField cpf) {
		this.telaDeletarPremium = telaDeletarPremium;
		this.cpf = cpf;
	}

	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();

	TelaMenuPremium telaTelaMenuPremium = new TelaMenuPremium();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("DELETAR")) {
			if (premiumRepositorioImplementacao.deletaPremiumRepositorio(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "Premium Deletado!!");
				telaDeletarPremium.setVisible(false);
				telaTelaMenuPremium.chamarTelaMenuPremium();
			}
		}
		if (e.getActionCommand().equals("MENU")) {
			telaDeletarPremium.setVisible(false);
			telaTelaMenuPremium.chamarTelaMenuPremium();
		}

	}

}
