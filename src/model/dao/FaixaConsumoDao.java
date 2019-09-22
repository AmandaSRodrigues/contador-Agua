package model.dao;

import model.entities.FaixaConsumo;


public interface FaixaConsumoDao {
	
	void atualizar(FaixaConsumo valor);
	void distribuir(FaixaConsumo service);
	void subTotal(FaixaConsumo subTotal);
	FaixaConsumo findByConsumo(String faixaDeConsumo);
}
