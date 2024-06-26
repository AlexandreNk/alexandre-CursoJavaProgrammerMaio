package repositorio;

import java.util.List;

import entidade.Basico;

public interface BasicoRepositorio {

	public boolean salvarBasicoRepositorio(Basico basico, String qtdeTransicao);

	public List<Basico> listarBasicoRepositorio();

	public boolean deletaBasicoRepositorio(String cpf);

	public boolean alterarBasicoRepositorio(Basico basico);
}
