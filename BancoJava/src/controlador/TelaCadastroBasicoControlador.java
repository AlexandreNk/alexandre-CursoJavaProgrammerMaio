package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCorrentista;
import entidade.Basico;
import repositorio.BasicoRepositorioImplementacao;
import tela.TelaMenuBasico;

public class TelaCadastroBasicoControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCpf;
	// JComboBox<TipoCorrentista> caixaSelecaoCorrentista;
	JTextField caixaTextoQuintoCampoRecebidoLimiteSaque;
	JTextField caixaTextoQuartoRecebidoQtdeTransacao;
	JFrame frameTelaCadastroBasico;
	JTextField jTextFieldCep;

	EnderecoCorrentista enderecoCorrentista = new EnderecoCorrentista();
	BasicoRepositorioImplementacao basicoRepositorioImplementacao = new BasicoRepositorioImplementacao();
	TelaMenuBasico telaBasico = new TelaMenuBasico();

	public TelaCadastroBasicoControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCpf, JTextField caixaTextoQuintoCampoRecebidoLimiteSaque,
			JTextField caixaTextoQuartoRecebidoQtdeTransacao, JFrame frameTelaCadastroBasico,
			JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaTextoQuintoCampoRecebidoLimiteSaque = caixaTextoQuintoCampoRecebidoLimiteSaque;
		this.caixaTextoQuartoRecebidoQtdeTransacao = caixaTextoQuartoRecebidoQtdeTransacao;
		this.frameTelaCadastroBasico = frameTelaCadastroBasico;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Basico basicoConfirmacao = populaBasico();
		int confirmacao = JOptionPane.showConfirmDialog(null,
				"Confirme os dados:" + "\n" + basicoConfirmacao.getNome() + "\n" + basicoConfirmacao.getCpf() + "\n"
						+ basicoConfirmacao.getEndereco().getBairro() + "\n"
						+ basicoConfirmacao.getEndereco().getLocalidade() + "\n"
						+ basicoConfirmacao.getEndereco().getLogradouro() + "\n"
						+ basicoConfirmacao.getEndereco().getUf() + "\n");
		if (confirmacao == 0) {
			registraNoBanco(basicoConfirmacao);
			frameTelaCadastroBasico.setVisible(false);
			telaBasico.chamarTelaMenuBasico();
		}

	}

	public Basico populaBasico() {

		Basico basico = new Basico();
		basico.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		basico.setCpf(caixaTextoSegundoCampoRecebidoCpf.getText());
		basico.setLimiteDeSaque(Double.parseDouble(caixaTextoQuintoCampoRecebidoLimiteSaque.getText()));
		try {
			basico.setEndereco(enderecoCorrentista.buscarEnderecoPeloCep(jTextFieldCep.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return basico;
	}

	public void registraNoBanco(Basico basicoConfirmado) {

		if (basicoRepositorioImplementacao.salvarBasicoRepositorio(basicoConfirmado,
				caixaTextoQuartoRecebidoQtdeTransacao.getText())) {
			JOptionPane.showMessageDialog(null, "Basico Registrado com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao registrar o basico");
		}

	}

}
