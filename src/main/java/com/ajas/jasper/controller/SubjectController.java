package com.ajas.jasper.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajas.jasper.service.StudentService;
import com.ajas.jasper.service.SubjectService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class SubjectController {

	@GetMapping("/studentreport")
	public String genaratePdf1(HttpServletResponse response) throws JRException, IOException {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				SubjectService.generatedSubjectList());
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/Student.jrxml"));

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("studentName", "John");
		parameters.put("tableData", beanCollectionDataSource);
		parameters.put("subReport", getSubReport());
		parameters.put("subDataSource", getSubDataSource());
		parameters.put("subParameteres", getSubParameteres());

		JasperPrint reports = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
		JasperExportManager.exportReportToPdfStream(reports, response.getOutputStream());
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=student.pdf;");

		return "genarated";

	}

	
	
	
	
	
	
	
	
	public static JasperReport getSubReport() {

		try {
			JasperReport compileReport = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/FirstReport.jrxml"));

			return compileReport;
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static JRBeanCollectionDataSource getSubDataSource() {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				StudentService.generatedStudentList());
		return beanCollectionDataSource;
	}

	public static Map<String, Object> getSubParameteres() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("firName", "Arun");
		return parameters;

	}

}
