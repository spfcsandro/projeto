package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario_tarde")
public class HorarioTarde {

	private Long idHorarioTarde;
	private String horaTarde;
	private String segundaTarde;
	private String tercaTarde;
	private String quartaTarde;
	private String quintaTarde;
	private String sextaTarde;

	@Id
	@GeneratedValue
	public Long getIdHorarioTarde() {
		return idHorarioTarde;
	}

	public void setIdHorarioTarde(Long idHorarioTarde) {
		this.idHorarioTarde = idHorarioTarde;
	}

	@Column (name="hora_tarde")
	public String getHoraTarde() {
		return horaTarde;
	}

	public void setHoraTarde(String horaTarde) {
		this.horaTarde = horaTarde;
	}

	@Column (name="segunda_tarde")
	public String getSegundaTarde() {
		return segundaTarde;
	}

	public void setSegundaTarde(String segundaTarde) {
		this.segundaTarde = segundaTarde;
	}

	@Column (name="terca_tarde")
	public String getTercaTarde() {
		return tercaTarde;
	}

	public void setTercaTarde(String tercaTarde) {
		this.tercaTarde = tercaTarde;
	}

	@Column (name="quarta_tarde")
	public String getQuartaTarde() {
		return quartaTarde;
	}

	public void setQuartaTarde(String quartaTarde) {
		this.quartaTarde = quartaTarde;
	}
	
	@Column (name="quinta_tarde")
	public String getQuintaTarde() {
		return quintaTarde;
	}

	public void setQuintaTarde(String quintaTarde) {
		this.quintaTarde = quintaTarde;
	}

	@Column (name="sexta_tarde")
	public String getSextaTarde() {
		return sextaTarde;
	}

	public void setSextaTarde(String sextaTarde) {
		this.sextaTarde = sextaTarde;
	}

}
