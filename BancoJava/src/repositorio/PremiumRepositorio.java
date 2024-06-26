package repositorio;

import java.util.List;

import entidade.Premium;

public interface PremiumRepositorio {

	public boolean salvarPremiumRepositorio(Premium premium, String qtdeTransicao);

	public List<Premium> listarPremiumRepositorio();

	public boolean deletaPremiumRepositorio(String cpf);

	public boolean alterarPremiumRepositorio(Premium premium);
}
