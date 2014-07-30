package com.webService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "frete")
public class FreteVO {

	private String uf;
	private String ufNome;
	private String destino;
	private String valor_sedex;
	private String valor_pac;
	private String status;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getUfNome() {
		return ufNome;
	}

	public void setUfNome(String ufNome) {
		this.ufNome = ufNome;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getValor_sedex() {
		return valor_sedex;
	}

	public void setValor_sedex(String valor_sedex) {
		this.valor_sedex = valor_sedex;
	}

	public String getValor_pac() {
		return valor_pac;
	}

	public void setValor_pac(String valor_pac) {
		this.valor_pac = valor_pac;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
