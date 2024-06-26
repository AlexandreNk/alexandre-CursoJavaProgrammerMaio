package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repositorio.PremiumRepositorioImplementacao;
import servico.EntidadeServico;
import tela.TelaMenuPremium;

public class TelaListarPremiumControlador implements ActionListener {

	JFrame telaListar;
	JTextField cpf;

	public TelaListarPremiumControlador(JFrame telaListar, JTextField cpf) {
		this.cpf = cpf;
		this.telaListar = telaListar;
	}

	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();
	EntidadeServico entidadeServico = new EntidadeServico();

	TelaMenuPremium telaMenuPremium = new TelaMenuPremium();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "MENU") {
			telaListar.setVisible(false);
			telaMenuPremium.chamarTelaMenuPremium();
		}

		if (e.getActionCommand() == "DETALHAR") {
			entidadeServico.gerarPdfDetalharPremium(premiumRepositorioImplementacao.buscaPremiumPorCpf(cpf.getText()));
		}
	}

}
