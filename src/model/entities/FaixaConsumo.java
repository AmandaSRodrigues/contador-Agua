package model.entities;

public class FaixaConsumo {
	
	private String faixaDeConsumo;
	private Double consumo;
	private Double tarifa;
	private Double distribuicao;
	private Double subTotal;
	
	public FaixaConsumo() {
	}

	public FaixaConsumo(String faixaDeConsumo, Double consumo, Double tarifa, Double distribuicao, Double subTotal) {
		this.faixaDeConsumo = faixaDeConsumo;
		this.consumo = consumo;
		this.tarifa = tarifa;
		this.distribuicao = distribuicao;
		this.subTotal = subTotal;
	}

	public String getFaixaDeConsumo() {
		return faixaDeConsumo;
	}

	public void setFaixaDeConsumo(String faixaDeConsumo) {
		this.faixaDeConsumo = faixaDeConsumo;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Double getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(Double distribuicao) {
		this.distribuicao = distribuicao;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faixaDeConsumo == null) ? 0 : faixaDeConsumo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaixaConsumo other = (FaixaConsumo) obj;
		if (faixaDeConsumo == null) {
			if (other.faixaDeConsumo != null)
				return false;
		} else if (!faixaDeConsumo.equals(other.faixaDeConsumo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Faixa de Consumo = " + faixaDeConsumo + ", tarifa = " + tarifa
				+ ", distribuicao = " + distribuicao + ", subTotal = " + subTotal + "]";
	}
}
