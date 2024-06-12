package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.CobraRepositorioImplementacao;
import tela.TelaCadastroCobra;
import tela.TelaDeletarCobra;

public class TelaMenuCobraControlador implements ActionListener {

	JTextField opcaoRecebida;
	JFrame frameTelaMenuCobra;

	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();
	TelaListaCobra telaListaCobra = new TelaListaCobra();
	TelaDeletarCobra telaDeletarCobra = new TelaDeletarCobra();
	
	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();
	//DaoCobra daoCobra = new DaoCobra();
	//List<Cobra> listCobra = new ArrayList<Cobra>();

	public TelaMenuCobraControlador(JTextField opcaoRecebida, JFrame frameTelaMenuCobra) {
		super();
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCobra = frameTelaMenuCobra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2") || opcaoRecebida.getText().equals("G3")) {
			switch (opcaoRecebida.getText()) {
			case "G1": {
				cadastroCobra.chamarTelaCadastroCobra();
				System.out.println("Direcione para cadastro de cobras");
				frameTelaMenuCobra.setVisible(false);
				break;
			}
			case "G2": {
				//cadastroCobra.imprimirCobra(daoCobra.retornaListaCobra());
				telaListaCobra.listaCobra(cobraRepositorio.listarCobraRepositorio());
				System.out.println("Direcione para lista de cobras");
				break;
			}
			case "G3": {
				telaDeletarCobra.chamarTelaDeletarCobra(cobraRepositorio.listarCobraRepositorio());
				System.out.println("Direcione para deletar cobra");
				break;
			}
			case "SAIR": {
				System.exit(0);
				break;
			}

			}
		} else {
			JOptionPane.showMessageDialog(null, "A opção " + opcaoRecebida.getText() + " não é válida");
		}

	}

}
