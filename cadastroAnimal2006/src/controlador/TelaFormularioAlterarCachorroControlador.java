package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import repositorio.CachorroRepositorioImplementacao;
import tela.TelaMenuCachorro;

public class TelaFormularioAlterarCachorroControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoCorPelo;
	JFrame	frameTelaAlterarCachorro;
	
	
	public TelaFormularioAlterarCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoCorPelo,
			JFrame frameTelaAlterarCachorro) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoCorPelo = caixaTextoTerceiroCampoRecebidoCorPelo;
		this.frameTelaAlterarCachorro = frameTelaAlterarCachorro;
	}

	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();
	TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();

	@Override
	public void actionPerformed(ActionEvent e) {
		alterarCachorroNoBanco();		
	}

	public void alterarCachorroNoBanco() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf);
		cachorro.setCorPelo(caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		
		if(cachorroRepositorioImplementacao.alterarCachorroRepositorio(cachorro)){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarCachorro.setVisible(false);
			telaMenuCachorro.chamarTelaMenuCachorro();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
			
		}
	}
}
