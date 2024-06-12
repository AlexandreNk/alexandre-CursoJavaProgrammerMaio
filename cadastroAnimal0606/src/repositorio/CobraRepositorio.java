package repositorio;

import java.util.List;

import entidade.Cobra;

public interface CobraRepositorio {
	
	public boolean salvarCobraRepositorio(Cobra cobra);
	
	public List<Cobra> listarCobraRepositorio();
	
	public boolean excluirCobraRepositorio(String caf);
}
