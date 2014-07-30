package com.webService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.util.LancaMenssagem;

@Service
public class CalculaFrete {

	@Resource
	LancaMenssagem menssagem;

	public CorreiosFreteVO getPreco(String nCdServico, String sCepOrigem,
			String sCepDestino, String nVlPeso, String nCdFormato,
			String nVlComprimento, String nVlAltura, String nVlLargura,
			String nVlDiametro)
			throws JAXBException, IOException, ParserConfigurationException,
			SAXException {

		String urls = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";

		Properties parameters = new Properties();

		parameters.setProperty("nCdEmpresa", "");
		parameters.setProperty("sDsSenha", "");
		parameters.setProperty("nCdServico", nCdServico);
		parameters.setProperty("sCepOrigem", sCepOrigem);
		parameters.setProperty("sCepDestino", sCepDestino);
		parameters.setProperty("nVlPeso", nVlPeso);
		parameters.setProperty("nCdFormato", nCdFormato);
		parameters.setProperty("nVlComprimento", nVlComprimento);
		parameters.setProperty("nVlAltura", nVlAltura);
		parameters.setProperty("nVlLargura", nVlLargura);
		parameters.setProperty("nVlDiametro", nVlDiametro);
		parameters.setProperty("sCdMaoPropria", "S");
		parameters.setProperty("nVlValorDeclarado", "0");
		parameters.setProperty("sCdAvisoRecebimento", "N");
		parameters.setProperty("StrRetorno", "xml");

		Iterator i = parameters.keySet().iterator();
		int counter = 0;

		while (i.hasNext()) {

			String name = (String) i.next();
			String value = parameters.getProperty(name);
			urls += (++counter == 1 ? "?" : "&") + name + "=" + value;

		}
		/* URL = http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?sCdAvisoRecebimento=n&nCdServico=41106&nVlComprimento=20&sCdMaoPropria=s&nCdEmpresa=&sCepOrigem=71939360&nVlAltura=5&sCepDestino=72151613&nVlValorDeclarado=0&sDsSenha=&nVlLargura=15&nVlDiametro=0&nVlPeso=1&StrRetorno=xml&nCdFormato=1*/
		Client c = Client.create();
		WebResource wr = c.resource(urls);
		String xmlString = wr.get(String.class);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();     
		DocumentBuilder db = dbf.newDocumentBuilder();     
		ByteArrayInputStream is = new ByteArrayInputStream (xmlString.getBytes()); 
		Document strXML = db.parse(is); 
		
		Element raiz = strXML.getDocumentElement();
/*		System.out.println("O elemento raiz é:" + raiz.getNodeName()); */
		
		NodeList list = raiz.getElementsByTagName("Servicos");
		return criarCorreiosVO(raiz);

	}

	public  String obterValorElemento(Element elemento, String nomeElemento){
		NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
		if (listaElemento == null) {
			return null;
		}
		Element noElemento = (Element) listaElemento.item(0);
		if (noElemento == null) {
			return null;
		}
		Node no = noElemento.getFirstChild();
		return no.getNodeValue();
	}
		
	
	public  CorreiosFreteVO criarCorreiosVO(Element elemento) {
		CorreiosFreteVO vo = new CorreiosFreteVO();
		vo.setValor((obterValorElemento(elemento,"Valor")));
		vo.setPrazoEntrega((obterValorElemento(elemento,"PrazoEntrega")));
		return vo;
	}

}
