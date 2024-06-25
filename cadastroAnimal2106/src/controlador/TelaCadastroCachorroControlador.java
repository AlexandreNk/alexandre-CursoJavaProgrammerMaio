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

public class TelaCadastroCachorroControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<CachorroEnum> caixaSelecaoCor;
	JTextField peso;
	JFrame frameTelaCadastroCachorro;
	JTextField jTextFieldCep;
	
	//ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//	DaoCachorro daoCachorro = new DaoCachorro();
	EnderecoCliente enderecoCliente = new EnderecoCliente();
	CachorroRepositorioImplementacao cachorroRepositorioImp = new CachorroRepositorioImplementacao();
	TelaMenuCachorro telaCachorro = new TelaMenuCachorro();
	

	public TelaCadastroCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JComboBox<CachorroEnum> caixaSelecaoCor,
			JFrame frameTelaCadastroCachorro, JTextField caixaTextoQuartoCampoRecebidoSetor, JTextField jTextFieldCep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoCor = caixaSelecaoCor;
		this.peso = caixaTextoQuartoCampoRecebidoSetor;
		this.frameTelaCadastroCachorro = frameTelaCadastroCachorro;
		this.jTextFieldCep = jTextFieldCep;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//registrarArquivo();
		/*14/06/2024
		System.out.println("O nome do cachorro: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("A cor do pelo: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		*/		
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
			registrarArquivo(cachorroConfirmacao);
			frameTelaCadastroCachorro.setVisible(false);
			telaCachorro.chamarTelaMenuCachorro();	
		}		
	}

	public Cachorro popularCachorro() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cachorro.setCorPelo(caixaSelecaoCor.getSelectedItem().toString());
		try {
			cachorro.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextFieldCep.getText()));	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cachorro;
	}
	
	public void registrarArquivo(Cachorro cachorroConfirmado) {
		//14/06/2024 manipuladorArquivo.registrarCachorro(cachorro);
		// daoCachorro.salvarCachorro(cachorro);

		if (cachorroRepositorioImp.salvarCachorroRepositorio(cachorroConfirmado, peso.getText())) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}

}
