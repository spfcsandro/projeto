package com.webService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Servicos")
public class CorreiosFreteVO {

	private int Codigo;
	private String Valor;
	private String PrazoEntrega;
	private String ValorMaoPropria;
	private String ValorAvisoRecebimento;
	private String ValorValorDeclarado;
	private String EntregaDomiciliar;
	private String EntregaSabado;

	public CorreiosFreteVO() {

	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getPrazoEntrega() {
		return PrazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}

	public String getValorMaoPropria() {
		return ValorMaoPropria;
	}

	public void setValorMaoPropria(String valorMaoPropria) {
		ValorMaoPropria = valorMaoPropria;
	}

	public String getValorAvisoRecebimento() {
		return ValorAvisoRecebimento;
	}

	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		ValorAvisoRecebimento = valorAvisoRecebimento;
	}

	public String getValorValorDeclarado() {
		return ValorValorDeclarado;
	}

	public void setValorValorDeclarado(String valorValorDeclarado) {
		ValorValorDeclarado = valorValorDeclarado;
	}

	public String getEntregaDomiciliar() {
		return EntregaDomiciliar;
	}

	public void setEntregaDomiciliar(String entregaDomiciliar) {
		EntregaDomiciliar = entregaDomiciliar;
	}

	public String getEntregaSabado() {
		return EntregaSabado;
	}

	public void setEntregaSabado(String entregaSabado) {
		EntregaSabado = entregaSabado;
	}

}
