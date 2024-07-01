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

	JTextField Nome;
	String Cpf;
	JTextField LimiteSaque;
	JFrame frameTelaAlterarBasico;

	
	public TelaFormularioAlteraBasicoControlador(JTextField nome, String cpf, JTextField limiteSaque,
			JFrame frameTelaAlterarBasico) {
		this.Nome = nome;
		this.Cpf = cpf;
		this.LimiteSaque = limiteSaque;
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
		basico.setCpf(Cpf);
		basico.setNome(Nome.getText());
		basico.setLimiteDeSaque(Double.parseDouble(LimiteSaque.getText()));

		if (basicoRepositorioImplementacao.alterarBasicoRepositorio(basico)) {
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			JOptionPane.showMessageDialog(null, "O Correntista Basico" + basico.getNome() + " Foi Alterado");
			frameTelaAlterarBasico.setVisible(false);
			telaMenuBasico.chamarTelaMenuBasico();
		} else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");

		}
	}
}
