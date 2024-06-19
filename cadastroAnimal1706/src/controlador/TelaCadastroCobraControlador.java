package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import enuns.CobraEnum;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaCadastroCobraControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<CobraEnum> caixaSelecaoTipoVeneno;
	JTextField peso;
	JFrame frameTelaCadastroCobra;

	//14/06/2024 ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//DaoCobra daoCobra = new DaoCobra();
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaCobra = new TelaMenuCobra();
	

	public TelaCadastroCobraControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JComboBox<CobraEnum> caixaSelecaoTipoVeneno,
			JFrame frameTelaCadastroCobra,JTextField caixaTextoQuartoCampoRecebidoSetor) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoTipoVeneno = caixaSelecaoTipoVeneno;
		this.peso = caixaTextoQuartoCampoRecebidoSetor;
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
		cobra.setTipoVeneno(caixaSelecaoTipoVeneno.getSelectedItem().toString());

		//14/06/2024 manipuladorArquivo.registrarCobra(cobra);
		// daoCobra.salvarCobra(cobra);

		if (cobraRepositorioImplementacao.salvarCobraRepositorio(cobra, peso.getText())) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}
}
