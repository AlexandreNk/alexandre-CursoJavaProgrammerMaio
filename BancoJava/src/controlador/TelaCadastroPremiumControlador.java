package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCorrentista;
import entidade.Premium;
import repositorio.PremiumRepositorioImplementacao;
import tela.TelaMenuPremium;

public class TelaCadastroPremiumControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCpf;
	// JComboBox<TipoCorrentista> caixaSelecaoCorrentista;
	JTextField caixaTextoQuintoCampoRecebidoLimiteCredito;
	JTextField caixaTextoQuartoRecebidoQtdeTransacao;
	JFrame frameTelaCadastroPremium;
	JTextField jTextFieldCep;

	EnderecoCorrentista enderecoCorrentista = new EnderecoCorrentista();
	PremiumRepositorioImplementacao premiumRepositorioImplementacao = new PremiumRepositorioImplementacao();
	TelaMenuPremium telaPremium = new TelaMenuPremium();

	public TelaCadastroPremiumControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCpf, JTextField caixaTextoQuintoCampoRecebidoLimiteCredito,
			JTextField caixaTextoQuartoRecebidoQtdeTransacao, JFrame frameTelaCadastroPremium,
			JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaTextoQuintoCampoRecebidoLimiteCredito = caixaTextoQuintoCampoRecebidoLimiteCredito;
		this.caixaTextoQuartoRecebidoQtdeTransacao = caixaTextoQuartoRecebidoQtdeTransacao;
		this.frameTelaCadastroPremium = frameTelaCadastroPremium;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Premium premiumConfirmacao = populaPremium();
		int confirmacao = JOptionPane.showConfirmDialog(null,
				"Confirme os dados:" + "\n" + premiumConfirmacao.getNome() + "\n" + premiumConfirmacao.getCpf() + "\n"
						+ premiumConfirmacao.getEndereco().getBairro() + "\n"
						+ premiumConfirmacao.getEndereco().getLocalidade() + "\n"
						+ premiumConfirmacao.getEndereco().getLogradouro() + "\n"
						+ premiumConfirmacao.getEndereco().getUf() + "\n");
		if (confirmacao == 0) {
			registraNoBanco(premiumConfirmacao);
			frameTelaCadastroPremium.setVisible(false);
			telaPremium.chamarTelaMenuPremium();
		}

	}

	public Premium populaPremium() {

		Premium premium = new Premium();
		premium.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		premium.setCpf(caixaTextoSegundoCampoRecebidoCpf.getText());
		premium.setLimiteCredito(Double.parseDouble(caixaTextoQuintoCampoRecebidoLimiteCredito.getText()));
		try {
			premium.setEndereco(enderecoCorrentista.buscarEnderecoPeloCep(jTextFieldCep.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return premium;
	}

	public void registraNoBanco(Premium premiumConfirmado) {

		if (premiumRepositorioImplementacao.salvarPremiumRepositorio(premiumConfirmado,
				caixaTextoQuartoRecebidoQtdeTransacao.getText())) {
			JOptionPane.showMessageDialog(null, "Premium Registrado com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao registrar o premium");
		}

	}

}
