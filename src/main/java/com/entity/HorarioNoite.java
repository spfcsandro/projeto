package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario_noite")
public class HorarioNoite {

	private Long idHorarioNoite;
	private String horaNoite;
	private String segundaNoite;
	private String tercaNoite;
	private String quartaNoite;
	private String quintaNoite;
	private String sextaNoite;

	@Id
	@GeneratedValue
	public Long getIdHorarioNoite() {
		return idHorarioNoite;
	}

	public void setIdHorarioNoite(Long idHorarioNoite) {
		this.idHorarioNoite = idHorarioNoite;
	}

	@Column(name = "hora_noite")
	public String getHoraNoite() {
		return horaNoite;
	}

	public void setHoraNoite(String horaNoite) {
		this.horaNoite = horaNoite;
	}

	@Column(name = "segunda_noite")
	public String getSegundaNoite() {
		return segundaNoite;
	}

	public void setSegundaNoite(String segundaNoite) {
		this.segundaNoite = segundaNoite;
	}

	@Column(name = "terca_noite")
	public String getTercaNoite() {
		return tercaNoite;
	}

	public void setTercaNoite(String tercaNoite) {
		this.tercaNoite = tercaNoite;
	}

	@Column(name = "quarta_noite")
	public String getQuartaNoite() {
		return quartaNoite;
	}

	public void setQuartaNoite(String quartaNoite) {
		this.quartaNoite = quartaNoite;
	}

	@Column(name = "quinta_noite")
	public String getQuintaNoite() {
		return quintaNoite;
	}

	public void setQuintaNoite(String quintaNoite) {
		this.quintaNoite = quintaNoite;
	}

	@Column(name = "sexta_noite")
	public String getSextaNoite() {
		return sextaNoite;
	}

	public void setSextaNoite(String sextaNoite) {
		this.sextaNoite = sextaNoite;
	}

}
