package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import gerenciaArquivo.ManipuladorArquivo;
import persistencia.DaoCobra;

public class TelaCadastroCobraControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoCorPelo;
	JFrame frameTelaCadastroCobra;

	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	DaoCobra daoCobra = new DaoCobra();

	public TelaCadastroCobraControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoCorPelo,
			JFrame frameTelaCadastroCobra) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoCorPelo = caixaTextoTerceiroCampoRecebidoCorPelo;
		this.frameTelaCadastroCobra = frameTelaCadastroCobra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		registrarArquivo();

		System.out.println("O nome da cobra: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("O tipo do veneno: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		frameTelaCadastroCobra.setVisible(false);
	}

	public void registrarArquivo() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setTipoVeneno(caixaTextoTerceiroCampoRecebidoCorPelo.getText());

		manipuladorArquivo.registrarCobra(cobra);
		// daoCobra.salvarCobra(cobra);

		if (daoCobra.salvarCobra(cobra)) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}
}
