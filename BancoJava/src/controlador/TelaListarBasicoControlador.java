package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repositorio.BasicoRepositorioImplementacao;
import servico.EntidadeServico;
import tela.TelaMenuBasico;

public class TelaListarBasicoControlador implements ActionListener {

	JFrame telaListar;
	JTextField cpf;

	public TelaListarBasicoControlador(JFrame telaListar, JTextField cpf) {
		this.cpf = cpf;
		this.telaListar = telaListar;
	}

	BasicoRepositorioImplementacao basicoRepositorioImplementacao = new BasicoRepositorioImplementacao();
	EntidadeServico entidadeServico = new EntidadeServico();

	TelaMenuBasico telaMenuBasico = new TelaMenuBasico();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "MENU") {
			telaListar.setVisible(false);
			telaMenuBasico.chamarTelaMenuBasico();
		}

		if (e.getActionCommand() == "DETALHAR") {
			entidadeServico.gerarPdfDetalharBasico(basicoRepositorioImplementacao.buscaBasicoPorCpf(cpf.getText()));
		}
	}

}
