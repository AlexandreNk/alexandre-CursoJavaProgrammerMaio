package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Basico;
import repositorio.BasicoRepositorioImplementacao;
import tela.TelaMenuBasico;

public class TelaFormularioAlteraBasicoControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCpf;
	// JTextField caixaTextoTerceiroCampoRecebidoGerencia;
	JTextField caixaTextoQuintoCampoRecebidoLimiteSaque;
	JFrame frameTelaAlterarBasico;

	public TelaFormularioAlteraBasicoControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCpf, JTextField caixaTextoQuintoCampoRecebidoLimiteSaque,
			JFrame frameTelaAlterarBasico) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaTextoQuintoCampoRecebidoLimiteSaque = caixaTextoQuintoCampoRecebidoLimiteSaque;
		this.frameTelaAlterarBasico = frameTelaAlterarBasico;
	}

	BasicoRepositorioImplementacao basicoRepositorioImplementacao = new BasicoRepositorioImplementacao();
	TelaMenuBasico telaMenuBasico = new TelaMenuBasico();

	@Override
	public void actionPerformed(ActionEvent e) {
		alterarBasicoNoBanco();

	}

	public void alterarBasicoNoBanco() {
		Basico basico = new Basico();
		basico.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		basico.setLimiteDeSaque(Double.parseDouble(caixaTextoQuintoCampoRecebidoLimiteSaque.getText()));
		//basico.setCpf(caixaTextoSegundoCampoRecebidoCpf);

		if (basicoRepositorioImplementacao.alterarBasicoRepositorio(basico)) {
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarBasico.setVisible(false);
			telaMenuBasico.chamarTelaMenuBasico();
		} else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");

		}
	}
}
