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

public class TelaFormularioAlterarCobraControlador implements ActionListener{

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<CobraEnum> caixaSelecaoTipoVeneno;
	JTextField peso;
	JFrame frameTelaAlterarCobra;
	JTextField jTextFieldCep;	
	

	
	EnderecoCliente enderecoCliente = new EnderecoCliente();
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
	

	public TelaFormularioAlterarCobraControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCaf, JComboBox<CobraEnum> caixaSelecaoTipoVeneno, JTextField peso,
			JFrame frameTelaAlterarCobra, JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoTipoVeneno = caixaSelecaoTipoVeneno;
		this.peso = peso;
		this.frameTelaAlterarCobra = frameTelaAlterarCobra;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//alterarCobraNoBanco();	
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
			alterarCobraNoBanco(cobraConfirmacao);
			frameTelaAlterarCobra.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();	
		}	
	}
	
	public Cobra popularCobra() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCAF(caixaTextoSegundoCampoRecebidoCaf);
		cobra.setTipoVeneno(caixaSelecaoTipoVeneno.getSelectedItem().toString());
		try {
			cobra.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextFieldCep.getText()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cobra;
	}

	public void alterarCobraNoBanco(Cobra cobraConfirmado) {
		
		if(cobraRepositorioImplementacao.alterarCobraRepositorio(cobraConfirmado,peso.getText())){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarCobra.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
			
		}
	}
}
