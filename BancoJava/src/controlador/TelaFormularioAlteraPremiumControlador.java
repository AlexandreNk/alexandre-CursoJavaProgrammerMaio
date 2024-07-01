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

	JTextField Nome;
	String Cpf;
	JTextField LimiteCredito;
	JFrame frameTelaAlterarPremium;

	public TelaFormularioAlteraPremiumControlador(JTextField nome, String cpf, JTextField limiteCredito,
			JFrame frameTelaAlterarPremium) {
		super();
		Nome = nome;
		Cpf = cpf;
		LimiteCredito = limiteCredito;
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
		premium.setCpf(Cpf);
		premium.setNome(Nome.getText());
		premium.setLimiteCredito(Double.parseDouble(LimiteCredito.getText()));

		if (premiumRepositorioImplementacao.alterarPremiumRepositorio(premium)) {
			JOptionPane.showMessageDialog(null, "Correntista Premium alterou com sucesso");
			frameTelaAlterarPremium.setVisible(false);
			telaMenuPremium.chamarTelaMenuPremium();
		} else {
			JOptionPane.showMessageDialog(null, "Correntista Premium não Alterou com sucesso");

		}
	}

}
