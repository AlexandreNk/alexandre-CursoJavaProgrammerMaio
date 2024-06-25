package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCliente;
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
	JTextField jTextFieldCep;
	
	//14/06/2024 ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//DaoCobra daoCobra = new DaoCobra();
	EnderecoCliente enderecoCliente = new EnderecoCliente();
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaCobra = new TelaMenuCobra();
	

	public TelaCadastroCobraControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JComboBox<CobraEnum> caixaSelecaoTipoVeneno,
			JFrame frameTelaCadastroCobra,JTextField caixaTextoQuartoCampoRecebidoSetor, JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoTipoVeneno = caixaSelecaoTipoVeneno;
		this.peso = caixaTextoQuartoCampoRecebidoSetor;
		this.frameTelaCadastroCobra = frameTelaCadastroCobra;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//registrarArquivo();
		/* 14/06/2024
		System.out.println("O nome da cobra: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("O tipo do veneno: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		*/
		Cobra cobraConfirmacao = popularCobra();
		int confirmacao = JOptionPane.showConfirmDialog(null, "Confirme os dados:" + "\n"
																+ cobraConfirmacao.getNome()+"\n"
																+ cobraConfirmacao.getCAF()+"\n"
																+ cobraConfirmacao.getEndereco().getBairro()+"\n"
																+ cobraConfirmacao.getEndereco().getLocalidade()+"\n"
																+ cobraConfirmacao.getEndereco().getLogradouro()+"\n"
																+ cobraConfirmacao.getEndereco().getUf()+"\n"
																);
		if (confirmacao==0) {
			registrarArquivo(cobraConfirmacao);
			frameTelaCadastroCobra.setVisible(false);
			telaCobra.chamarTelaMenuCobra();	
		}		
	}

	public Cobra popularCobra() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setTipoVeneno(caixaSelecaoTipoVeneno.getSelectedItem().toString());
		try {
			cobra.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextFieldCep.getText()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cobra;
	}
	
	public void registrarArquivo(Cobra cobraConfirmado) {
		//14/06/2024 manipuladorArquivo.registrarCobra(cobra);
		// daoCobra.salvarCobra(cobra);

		if (cobraRepositorioImplementacao.salvarCobraRepositorio(cobraConfirmado, peso.getText())) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}
}
