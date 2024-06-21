package repositorio;

import java.util.List;

import entidade.Cobra;

public interface CobraRepositorio {
	
	boolean salvarCobraRepositorio(Cobra cobra, String peso);

	public List<Cobra> listarCobraRepositorio();
	
	public boolean excluirCobraRepositorio(String caf);
	
	public boolean alterarCobraRepositorio(Cobra cobra);
	
	public Cobra buscaCobraPorCaf(String caf);

		
}
