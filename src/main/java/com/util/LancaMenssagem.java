package com.util;

import static com.util.ConstantesUtilWeb.MENSAGEM_ALERTA;
import static com.util.ConstantesUtilWeb.MENSAGEM_AVISO;
import static com.util.ConstantesUtilWeb.MENSAGEM_ERRO;
import static com.util.ConstantesUtilWeb.MENSAGEM_ERRO_FATAL;
import static com.util.ConstantesUtilWeb.MENSAGEM_SUCESSO;
import static com.util.ConstantesUtilWeb.MENSAGEM_CAMPOS_NULOS;
import static com.util.ConstantesUtilWeb.MENSAGEM_CEP_NAO_ENCONTRADO;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("LancaMenssagem")
public class LancaMenssagem {
	
	
	private boolean verificarContexto() {
		FacesContext context = getContext();
		return VerificadorUtil.naoEstaNulo(context)
				&& VerificadorUtil.naoEstaNulo(context.getExternalContext());
	}
	
	public FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public HttpServletRequest getRequest() {
		return verificarContexto() ? (HttpServletRequest) getContext()
				.getExternalContext().getRequest() : null;
	}

	public HttpServletResponse getResponse() {
		return verificarContexto() ? (HttpServletResponse) getContext()
				.getExternalContext().getResponse() : null;
	}

	
	public void lancarSucesso(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, MENSAGEM_SUCESSO,
						mensagem));
	}

	public void lancarInformacao(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, MENSAGEM_AVISO,
						mensagem));
		
	}
	
	public void lancarMensagemCampoNulos(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, MENSAGEM_CAMPOS_NULOS,
						mensagem));
	}
	
	public void lancarMensagemCEPNaoEncontrado(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, MENSAGEM_CEP_NAO_ENCONTRADO,
						mensagem));
	}
	
	public void lancarMensagem(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem,
						""));
	}
	

	public void lancarAlerta(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, MENSAGEM_ALERTA,
						mensagem));
	}

	public void lancarErro(String mensagem) {
		if (mensagem.contains(";")) {
			String[] mensagens = mensagem.split(";");
			for (String mensagemDeErro : mensagens) {
				getContext().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								MENSAGEM_ERRO, mensagemDeErro));
			}
		} else {
			getContext().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							MENSAGEM_ERRO, mensagem));
		}
	}

	public void lancarErroFatal(String mensagem) {
		getContext().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL,
						MENSAGEM_ERRO_FATAL, mensagem));
	}

	public void lancarSucessoRedirecionandoTelaComCallBack(String mensagem,
			String urlCallBack) {
		try {
			getContext().getExternalContext().redirect(urlCallBack);
			getContext().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							MENSAGEM_SUCESSO, mensagem));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
