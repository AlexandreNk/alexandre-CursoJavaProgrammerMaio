package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaFormularioAlterarCobraControlador implements ActionListener{

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoTipoVeneno;
	JFrame	frameTelaAlterarCobra;

	
	public TelaFormularioAlterarCobraControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoTipoVeneno,
			JFrame frameTelaAlterarCobra) {
		super();
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoTipoVeneno = caixaTextoTerceiroCampoRecebidoTipoVeneno;
		this.frameTelaAlterarCobra = frameTelaAlterarCobra;
	}

	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();

	@Override
	public void actionPerformed(ActionEvent e) {
		alterarCobraNoBanco();		
	}
	
	public void alterarCobraNoBanco() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCAF(caixaTextoSegundoCampoRecebidoCaf);
		cobra.setTipoVeneno(caixaTextoTerceiroCampoRecebidoTipoVeneno.getText());
		
		if(cobraRepositorioImplementacao.alterarCobraRepositorio(cobra)){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarCobra.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
			
		}
	}

	

}
