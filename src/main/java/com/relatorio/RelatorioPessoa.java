package com.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entity.Pessoa;
import com.util.ConnectionFactory;
@Controller
@Component
@Scope("session")
public class RelatorioPessoa {

	 Pessoa pessoa = new Pessoa();
	 ConnectionFactory con;
	 

	JasperPrint jasperPrint;
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void pdf() throws JRException, IOException, SQLException{
		HashMap parameters = new HashMap();
		parameters.put("p_nome", pessoa.getNome());
		
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

			JasperPrint jasperPrint = JasperFillManager.fillReport(
							scontext.getRealPath("/WEB-INF/ireport/cadastroPessoa.jasper"),
							parameters, con.getConnection());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();

			byte[] bytes = baos.toByteArray();

			if (bytes != null && bytes.length > 0) {
				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				response.setContentType("application/pdf");

				response.setHeader("Content-disposition","inline; filename=\"pessoa.pdf\"");
				response.setContentLength(bytes.length);
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(bytes, 0, bytes.length);
				outputStream.flush();
				outputStream.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.getConnection().close(); } catch (SQLException e) {
				}
			}
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void xls() throws Exception {  
	          
			HashMap parameters = new HashMap();
			parameters.put("p_nome", pessoa.getNome());
	  
	            try {  
	            	FacesContext facesContext = FacesContext.getCurrentInstance();
	            	ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();  
	                String path = scontext.getRealPath("/WEB-INF/ireport/cadastroPessoa.jrxml");  
	                  
	                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
	                response.setContentType("application/vnd.ms-excel");  
	                response.setHeader("Content-disposition", "attachment;filename=pessoa.xls");  
	  
	                JasperReport jasperReport2  = JasperCompileManager.compileReport(path);  
	  
	                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport2, parameters, con.getConnection());  
	  
	                ByteArrayOutputStream output = new ByteArrayOutputStream();  
	                JRXlsExporter xls = new JRXlsExporter();  
	  
	                xls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);  
	                xls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,output);  
	                xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET,Integer.decode("65000"));  
	                xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.IS_IMAGE_BORDER_FIX_ENABLED, Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);  
	                xls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);  
	                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  
	  
	                xls.exportReport();  
	                byte[] bytes = output.toByteArray();  
	  
	                response.setContentLength(bytes.length);  
	                ServletOutputStream outputStream = response.getOutputStream();  
	                outputStream.write(bytes,0,bytes.length);  
	                output.flush();  
	                output.close();  
	                  
	                FacesContext.getCurrentInstance().responseComplete();  
	  
	            } catch (Exception ex) {  
	               throw  new Exception(ex.getMessage());  
	            }  
	     }  
	
	 
	public void tipoSaida() throws Exception{
		if (this.pessoa.getRelatorio().equals("PDF")) {
			pdf();
		}
		if (this.pessoa.getRelatorio().equals("XLS")) {
			xls();
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
