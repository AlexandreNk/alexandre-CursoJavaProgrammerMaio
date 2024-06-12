package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.CobraRepositorioImplementacao;
import tela.TelaCadastroCobra;
import tela.TelaDeletarCobra;
import tela.TelaSelecionarAlterarCobra;

public class TelaMenuCobraControlador implements ActionListener {

	JTextField opcaoRecebida;
	JFrame frameTelaMenuCobra;

	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();
	TelaListaCobra telaListaCobra = new TelaListaCobra();
	TelaDeletarCobra telaDeletarCobra = new TelaDeletarCobra();
	TelaSelecionarAlterarCobra alterarSelecionarCobra = new TelaSelecionarAlterarCobra();
	
	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();

	//DaoCobra daoCobra = new DaoCobra();
	//List<Cobra> listCobra = new ArrayList<Cobra>();

	public TelaMenuCobraControlador(JTextField opcaoRecebida, JFrame frameTelaMenuCobra) {
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCobra = frameTelaMenuCobra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2") || opcaoRecebida.getText().equals("G3")  || opcaoRecebida.getText().equals("G4")) {
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
			case "G4": {
				alterarSelecionarCobra.chamarTelaDeletarCobra(cobraRepositorio.listarCobraRepositorio());
				System.out.println("Direcione para alterar a cobra");
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
