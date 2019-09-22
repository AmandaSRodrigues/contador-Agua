package application;

import model.dao.DaoSabesp;
import model.dao.FaixaConsumoDao;
import model.entities.FaixaConsumo;

public class Facilitador {
	
	FaixaConsumoDao faixaConsumoDao = DaoSabesp.createSellerDao();
	
	public FaixaConsumo distribuicao10(Double consumoTotal) {
		if (consumoTotal <= 10) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("Até 10"); 
			fxCon.setDistribuicao(consumoTotal);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(26.18);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal > 10) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("Até 10");
			fxCon.setDistribuicao(10.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(26.18);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
			}
		return null;
	}
	
	public FaixaConsumo distribuicao20(Double consumoTotal) {
		if (consumoTotal <= 10) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("11 a 20");
			fxCon.setDistribuicao(0.0);
			faixaConsumoDao.distribuir(fxCon);
			faixaConsumoDao.findByConsumo("11 a 20");
			fxCon.setSubTotal(0.0);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal <= 20 && consumoTotal > 10) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("11 a 20");
			fxCon.setDistribuicao(consumoTotal - 10);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal((consumoTotal -10) * 4.10);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal > 20) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("11 a 20");
			fxCon.setDistribuicao(10.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(10.0 * 4.10);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		return null;
	}
	
	public FaixaConsumo distribuicao30(Double consumoTotal) {
		if (consumoTotal <= 20) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("21 a 30");
			fxCon.setDistribuicao(0.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(0.0);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal <= 30 && consumoTotal >= 20) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("21 a 30");
			fxCon.setDistribuicao(consumoTotal - 20);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal((consumoTotal - 20) * 10.23);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal > 30) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("21 a 30");
			fxCon.setDistribuicao(10.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(10.0 * 10.23);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		return null;
	}
	
	public FaixaConsumo distribuicao50(Double consumoTotal) {
		if (consumoTotal <= 30) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("31 a 50");
			fxCon.setDistribuicao(0.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(0.0);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal <= 50 && consumoTotal >= 30) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("31 a 50");
			fxCon.setDistribuicao(consumoTotal - 30);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal((consumoTotal - 30) * 10.23);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal > 50) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("31 a 50");
			fxCon.setDistribuicao(20.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(20.0 * 10.23);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		return null;
	}

	public FaixaConsumo distribuicao51(Double consumoTotal) {
		if (consumoTotal <= 50) {
			FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("acima de 50");
			fxCon.setDistribuicao(0.0);
			faixaConsumoDao.distribuir(fxCon);
			fxCon.setSubTotal(0.0);
			faixaConsumoDao.subTotal(fxCon);
			return fxCon;
		}
		else if (consumoTotal > 50) {
				FaixaConsumo fxCon = faixaConsumoDao.findByConsumo("acima de 50");
				fxCon.setDistribuicao(consumoTotal - 50);
				faixaConsumoDao.distribuir(fxCon);
				fxCon.setSubTotal((consumoTotal - 50) * 11.27);
				faixaConsumoDao.subTotal(fxCon);
				return fxCon;
	}
		return null;
	}
	
}
