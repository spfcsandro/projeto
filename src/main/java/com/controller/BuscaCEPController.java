package com.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.webService.BuscaCep;
import com.webService.WebserviceCepVO;

@ManagedBean
@Controller
@Component
@Scope("view") 
public class BuscaCEPController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cep = null;
	@Autowired private BuscaCep buscaCEP;
	private WebserviceCepVO cepEndereco;


	public void buscaCEP() throws JAXBException, IOException {
		cepEndereco = buscaCEP.getEndereco(getCep());
	}

	public WebserviceCepVO getCEPEndereco(){
		return cepEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}