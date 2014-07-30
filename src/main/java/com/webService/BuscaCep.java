package com.webService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.util.LancaMenssagem;

@Service
public class BuscaCep {

	@Resource
	LancaMenssagem menssagem;

	public WebserviceCepVO getEndereco(String cep) throws JAXBException,
			IOException {

		try {

			JAXBContext jc = JAXBContext.newInstance(WebserviceCepVO.class);

			Unmarshaller u = jc.createUnmarshaller();
			URL url = new URL(
					"http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep
							+ "&formato=xml");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestProperty("Request-Method", "GET");

			return populaVO((WebserviceCepVO) u.unmarshal(url));

		} catch (Exception e) {
			e.printStackTrace();
			menssagem.lancarMensagem("Erro na conexão com o WebService !");
			return new WebserviceCepVO();
		}

	}

	private WebserviceCepVO populaVO(WebserviceCepVO item) {
		WebserviceCepVO vo = new WebserviceCepVO();
		if (item.getResultado().equals("1")) {
			vo.setCidade(item.getCidade());
			vo.setBairro(item.getBairro());
			vo.setUf(item.getUf());
			vo.setTipo_logradouro(item.getTipo_logradouro());
			vo.setLogradouro(item.getLogradouro());
		} else {
			menssagem.lancarMensagemCEPNaoEncontrado("");
		}
		return vo;
	}

}
