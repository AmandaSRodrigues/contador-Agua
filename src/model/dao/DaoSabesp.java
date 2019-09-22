package model.dao;

import db.DB;
import model.dao.impl.FaixaConsumoDaoJDBC;

public class DaoSabesp {
	
	public static FaixaConsumoDao createSellerDao() {
		return new FaixaConsumoDaoJDBC(DB.getConnection());
	}
}
