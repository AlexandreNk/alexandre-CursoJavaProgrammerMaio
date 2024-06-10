package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import gerenciaArquivo.ManipuladorArquivo;
import persistencia.DaoCachorro;

public class TelaCadastroCachorroControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoCorPelo;
	JFrame frameTelaCadastroCachorro;

	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	DaoCachorro daoCachorro = new DaoCachorro();

	public TelaCadastroCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoCorPelo,
			JFrame frameTelaCadastroCachorro) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoCorPelo = caixaTextoTerceiroCampoRecebidoCorPelo;
		this.frameTelaCadastroCachorro = frameTelaCadastroCachorro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		registrarArquivo();

		System.out.println("O nome do cachorro: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("A cor do pelo: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		frameTelaCadastroCachorro.setVisible(false);

	}

	public void registrarArquivo() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cachorro.setCorPelo(caixaTextoTerceiroCampoRecebidoCorPelo.getText());

		manipuladorArquivo.registrarCachorro(cachorro);
		// daoCachorro.salvarCachorro(cachorro);

		if (daoCachorro.salvarCachorro(cachorro)) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}

}
