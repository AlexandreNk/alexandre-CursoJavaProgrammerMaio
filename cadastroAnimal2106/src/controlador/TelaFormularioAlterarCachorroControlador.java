package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCliente;
import entidade.Cachorro;
import enuns.CachorroEnum;
import repositorio.CachorroRepositorioImplementacao;
import tela.TelaMenuCachorro;

public class TelaFormularioAlterarCachorroControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<CachorroEnum> caixaSelecaoCor;
	JTextField peso;
	JFrame frameTelaAlterarCachorro;
	JTextField jTextFieldCep;	
	
	

	EnderecoCliente enderecoCliente = new EnderecoCliente();
	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();	

	
	public TelaFormularioAlterarCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCaf, JComboBox<CachorroEnum> caixaSelecaoCor, JTextField peso,
			JFrame frameTelaAlterarCachorro, JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoCor = caixaSelecaoCor;
		this.peso = peso;
		this.frameTelaAlterarCachorro = frameTelaAlterarCachorro;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//alterarCachorroNoBanco();
		Cachorro cachorroConfirmacao = popularCachorro();
		int confirmacao = JOptionPane.showConfirmDialog(null, "Confirme os dados:" + "\n"
																+ cachorroConfirmacao.getNome()+"\n"
																+ cachorroConfirmacao.getCAF()+"\n"
																+ cachorroConfirmacao.getEndereco().getBairro()+"\n"
																+ cachorroConfirmacao.getEndereco().getLocalidade()+"\n"
																+ cachorroConfirmacao.getEndereco().getLogradouro()+"\n"
																+ cachorroConfirmacao.getEndereco().getUf()+"\n"
																);
		if (confirmacao==0) {
			alterarCachorroNoBanco(cachorroConfirmacao);
			frameTelaAlterarCachorro.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();	
		}	
	}

	public Cachorro popularCachorro() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf);
		cachorro.setCorPelo(caixaSelecaoCor.getSelectedItem().toString());
		try {
			cachorro.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextFieldCep.getText()));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cachorro;
	}
	
	public void alterarCachorroNoBanco(Cachorro cachorroConfirmado) {
		
		if(cachorroRepositorioImplementacao.alterarCachorroRepositorio(cachorroConfirmado,peso.getText())){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarCachorro.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
			
		}
	}
}
