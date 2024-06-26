package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Premium;
import repositorio.PremiumRepositorioImplementacao;
import tela.TelaMenuPremium;

public class TelaFormularioAlteraPremiumControlador implements ActionListener {
	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCpf;
	// JTextField caixaTextoTerceiroCampoRecebidoGerencia;
	JTextField caixaTextoQuintoCampoRecebidoLimiteCredito;
	JFrame frameTelaAlterarPremium;

	public TelaFormularioAlteraPremiumControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCpf, JTextField caixaTextoQuintoCampoRecebidoLimiteCredito,
			JFrame frameTelaAlterarPremium) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaTextoQuintoCampoRecebidoLimiteCredito = caixaTextoQuintoCampoRecebidoLimiteCredito;
		this.frameTelaAlterarPremium = frameTelaAlterarPremium;
	}

	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();
	TelaMenuPremium telaMenuPremium = new TelaMenuPremium();

	@Override
	public void actionPerformed(ActionEvent e) {
		alterarPremiumNoBanco();

	}

	public void alterarPremiumNoBanco() {
		Premium premium = new Premium();
		premium.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		premium.setLimiteCredito(Double.parseDouble(caixaTextoQuintoCampoRecebidoLimiteCredito.getText()));
		// premium.setCpf(caixaTextoSegundoCampoRecebidoCpf);

		if (premiumRepositorioImplementacao.alterarPremiumRepositorio(premium)) {
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarPremium.setVisible(false);
			telaMenuPremium.chamarTelaMenuPremium();
		} else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");

		}
	}

}
