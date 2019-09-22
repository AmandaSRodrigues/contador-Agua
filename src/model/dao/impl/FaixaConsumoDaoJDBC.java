package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.FaixaConsumoDao;
import model.entities.FaixaConsumo;

public class FaixaConsumoDaoJDBC implements FaixaConsumoDao {

	private Connection conn;

	public FaixaConsumoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void atualizar(FaixaConsumo valor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void distribuir(FaixaConsumo service) {
		PreparedStatement st = null;
		try {
				st = conn.prepareStatement(
						"UPDATE faixaconsumo " 
						+ "SET Distribuicao = ? " 
						+ "WHERE FaixaDeConsumo = ?");
				
				st.setDouble(1, service.getDistribuicao());
				st.setString(2, service.getFaixaDeConsumo());
				
				st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void subTotal(FaixaConsumo service) {
		PreparedStatement st = null;
		try {
				st = conn.prepareStatement(
						"UPDATE faixaconsumo " 
						+ "SET SubTotal = ? " 
						+ "WHERE FaixaDeConsumo = ?");
				
				st.setDouble(1, service.getSubTotal());
				st.setString(2, service.getFaixaDeConsumo());
				
				st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	@Override
	public FaixaConsumo findByConsumo(String faixaDeConsumo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM faixaconsumo WHERE FaixaDeConsumo = ?");
			st.setString(1, faixaDeConsumo);
			rs = st.executeQuery();
			if (rs.next()) {
				FaixaConsumo service = new FaixaConsumo();
				service.setFaixaDeConsumo(rs.getString("FaixaDeConsumo"));
				service.setTarifa(rs.getDouble("Tarifa"));
				service.setDistribuicao(rs.getDouble("Distribuicao"));
				service.setSubTotal(rs.getDouble("SubTotal"));

				return service;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
