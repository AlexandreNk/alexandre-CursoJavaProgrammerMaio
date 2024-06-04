package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entidade.Cachorro;
import gerenciaArquivo.ManipuladorArquivo;

public class TelaCadastroCachorroControlador implements ActionListener {

	
	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoCorPelo;
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	
	public TelaCadastroCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoCorPelo) {
		
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoCorPelo = caixaTextoTerceiroCampoRecebidoCorPelo;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		registrarArquivo();
		
		System.out.println("O nome do cachorro: "+ caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: "+ caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("A cor do pelo: "+ caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		
	}
	
	public void registrarArquivo() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cachorro.setCorPelo(caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		
		manipuladorArquivo.registrarCachorro(cachorro);
	}
}
