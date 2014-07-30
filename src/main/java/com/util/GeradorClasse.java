package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class GeradorClasse {

	private static BufferedReader br;
	private static String SUFIXO_INTERFACE = "I";
	private static ArrayList<String> listaRetorno = new ArrayList<String>();
	
	private static String ENTIDADE = "Pessoa";
	private static String NOVO_ENTIDADE = JOptionPane.showInputDialog("Digite o nome da Entidade:");
	
	private static String DAO = "PessoaDAO.java";
	private static String NOVO_DAO = NOVO_ENTIDADE.concat(DAO.substring(6,14));
	
	private static String INTERFACES = "IPessoaDAO.java";
	private static String NOVO_INTERFACES = SUFIXO_INTERFACE.concat(NOVO_ENTIDADE).concat(DAO.substring(6,14));
	
	private static String CONTROLLER= "PessoaController.java";
	private static String NOVO_CONTROLLER = NOVO_ENTIDADE.concat(CONTROLLER.substring(6,21));
	
	private static String PRE_SUFIXO = "pessoa";
	private static String SUFIXO_ENTIDADE = NOVO_ENTIDADE.substring(0,1).toLowerCase() + NOVO_ENTIDADE.substring(1);
	
	private static String SERVICE = "PessoaService.java";
	private static String NOVO_SERVICE = NOVO_ENTIDADE.concat(SERVICE.substring(6,18));
	
	private static String INTERFACES_SERVICE = "IPessoaService.java";
	private static String NOVO_INTERFACE_SERVICE = SUFIXO_INTERFACE.concat(NOVO_ENTIDADE).concat(SERVICE.substring(6,18));
	
	private static String INDEX = "cadastroPessoa.xhtml";
	private static String NOVO_INDEX = NOVO_ENTIDADE.concat(INDEX.substring(8,20));
	
	//private static String CAMINHO = "//Users//JadersonMorais//Projetos//Desenvolvimento//src//main//java//com";
	//private static String CAMINHO_INDEX = "//Users//JadersonMorais//Projetos//Desenvolvimento//src//main//webapp";
	private static String CAMINHO = "D:\\Estudos\\Desenvolvimento\\src\\main\\java\\com";
	private static String CAMINHO_INDEX = "D:\\Estudos\\Desenvolvimento\\src\\main\\webapp";
	
	private static String SUFIXO_CONTROLLER = "//controller//";
	private static String SUFIXO_INTERFACES = "//interfaces//";
	private static String SUFIXO_SERVICE = "//service//";
	private static String SUFIXO_DAO = "//dao//";
	private static String SUFIXO_INDEX = "//pages//";
	
	public static void controllerAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_CONTROLLER + CONTROLLER);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			listaRetorno.add("Diretório Criado: " + CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
			
			bw.close();
		}
		
		
	}
	
	public static void interfaceServiceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES_SERVICE);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.interfaces");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			listaRetorno.add("Diretório Criado: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
			
			bw.close();
		}
		
		
	}
	
	public static void serviceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_SERVICE + SERVICE);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.service");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			listaRetorno.add("Diretório Criado: " + CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
			
			bw.close();
		}
		
		
	}
	
	public static void interfaceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.interfaces");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			listaRetorno.add("Diretório Criado: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
			
			bw.close();
		}
		
		
	}
	
	public static void daoAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_DAO + NOVO_DAO);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO_INDEX + SUFIXO_DAO + NOVO_DAO);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_DAO + DAO);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.dao");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			listaRetorno.add("Diretório Criado: " + CAMINHO_INDEX + SUFIXO_DAO + NOVO_DAO);
			
			bw.close();
		}
		
		
	}
	
	public static void indexAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(caminhoNovo);
		if(arquivo.exists()){
			listaRetorno.add("Diretório já existe: " + CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO_INDEX + SUFIXO_INDEX + INDEX);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("pessoaController", "testeController");
				s = s.replace("pessoas", "testes");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			
			listaRetorno.add("Diretório Criado: " + CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);
			bw.close();
			
		}
		
	}
	
	public static void apagarPasta(String caminho) {
		  
		  File arquivo = new File(caminho);
		  if(arquivo.exists()){
			if(arquivo.delete()){
				listaRetorno.add("Diretório apagado: " + caminho);
				}
			}else{
				listaRetorno.add("Diretório não existe: " + caminho);
		  }
	}
	
	public static void pecorreLista(){
		String s = "";
		for (String lista : listaRetorno) {
			s += lista + "\n";  
		}  
		
		JOptionPane.showMessageDialog(null, s);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		for (int opcao = 0; opcao != 3;) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Gerar classe Crud\n2 - Apagar classe Crud\n3 - Sair"));
            if (opcao == 1) {
            	/* 	GERADOR DE CRUD	     */
            	controllerAserCopiado(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
            	interfaceServiceAserCopiado(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
            	serviceAserCopiado(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
            	interfaceAserCopiado(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
            	daoAserCopiado(CAMINHO + SUFIXO_DAO + NOVO_DAO);
            	indexAserCopiado(CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);  
            	pecorreLista();
                
            }
 
            if (opcao == 2) {
            	/*  APAGAR OS ARQUIVOS COPIADOS  */       
            	apagarPasta(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
            	apagarPasta(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
            	apagarPasta(CAMINHO + SUFIXO_DAO + NOVO_DAO);
            	apagarPasta(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE); 
            	apagarPasta(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);   
            	apagarPasta(CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX );      
            	pecorreLista();
                
            }
		}				
	}
} 
	
