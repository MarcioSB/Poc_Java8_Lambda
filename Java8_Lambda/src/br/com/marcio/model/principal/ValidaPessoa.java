package br.com.marcio.model.principal;

import br.com.marcio.model.pojo.Pessoa;

public class ValidaPessoa implements IValidaPessoa {

	@Override
	public void valida(Pessoa pessoa) {
		this.validaPessoaSemNome(pessoa);
	}
	
	public void validaPessoaSemNome(Pessoa pessoa){
		if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			System.out.println("A lista possui uma Pessoa sem nome informado.");
		}
	}
}
