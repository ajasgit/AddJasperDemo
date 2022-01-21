package com.ajas.jasper.controller;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajas.jasper.service.StudentService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class StudentController {

	@GetMapping("/report")
	public String genaratePdf(HttpServletResponse response) throws JRException, IOException {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				StudentService.generatedStudentList());
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/FirstReport.jrxml"));

		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("firName", "Arun");
		//parameters.put("lName", "Akhil");

		JRBaseTextField textField =(JRBaseTextField) compileReport.getTitle().getElementByKey("name");
		
		textField.setForecolor(Color.RED);
		JasperPrint reports = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
		JasperExportManager.exportReportToPdfStream(reports, response.getOutputStream());
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=FirstReport.pdf;");
		
		//JasperExportManager.exportReportToPdfFile(reports, "FirstReport.pdf");

		
		//byte data[] = JasperExportManager.exportReportToPdf(reports);
		//HttpHeaders headers=new HttpHeaders();
		//headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=report.pdf");
		
		return "genarated";

	}
	
	
	
}
