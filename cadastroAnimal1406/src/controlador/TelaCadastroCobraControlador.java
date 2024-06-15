package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaCadastroCobraControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoCorPelo;
	JFrame frameTelaCadastroCobra;

	//14/06/2024 ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//DaoCobra daoCobra = new DaoCobra();
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaCobra = new TelaMenuCobra();
	

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
		/* 14/06/2024
		System.out.println("O nome da cobra: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("O tipo do veneno: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		*/
		frameTelaCadastroCobra.setVisible(false);
		telaCobra.chamarTelaMenuCobra();
	}

	public void registrarArquivo() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setTipoVeneno(caixaTextoTerceiroCampoRecebidoCorPelo.getText());

		//14/06/2024 manipuladorArquivo.registrarCobra(cobra);
		// daoCobra.salvarCobra(cobra);

		if (cobraRepositorioImplementacao.salvarCobraRepositorio(cobra)) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}
}
