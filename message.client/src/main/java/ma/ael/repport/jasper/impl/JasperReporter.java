package ma.ael.repport.jasper.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import ma.ael.repport.jasper.exception.ReportingException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReporter {

	private static JasperReporter instance;
	private static String EDITION_FOLDER = "editions/";
	private static String JRXML_EXT = ".jrxml";
	private static String JASPER_EXT = ".jasper";

	private JasperReporter() {
	}

	public static synchronized JasperReporter getInstance() {
		if ( instance == null ) {
			instance = new JasperReporter();
		}
		return instance;
	}

	public static void replace(String oldstring, String newstring, File in, File out) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(in));
		PrintWriter writer = new PrintWriter(new FileWriter(out));
		String line = null;

		while ((line = reader.readLine()) != null) {
			String tmp = line.replaceAll(oldstring, newstring);
			writer.println(tmp);
		}

		reader.close();
		writer.close();
	}
	
	public String compile(String inputFileJasper, String inputFileJasperSub) throws Exception {

		inputFileJasper = this.getClass().getClassLoader().getResource( EDITION_FOLDER + inputFileJasper + JRXML_EXT).getPath();

		String inputFileJasperOut = inputFileJasper.replaceAll(inputFileJasper, inputFileJasper + "Out");

		String compiledFileJasper = inputFileJasper.replaceAll(JRXML_EXT, JASPER_EXT);

		String inputFileJasperSubOrig = inputFileJasperSub;
		inputFileJasperSub = this.getClass().getClassLoader().getResource( EDITION_FOLDER + inputFileJasperSub + JRXML_EXT).getPath();

		String compiledFileJasperSub = inputFileJasperSub.replaceAll(JRXML_EXT, JASPER_EXT);
		
		File jrxml = new File(inputFileJasper);
		File jrxmlOut = new File(inputFileJasperOut);

		replace(inputFileJasperSubOrig + JASPER_EXT, compiledFileJasperSub, jrxml, jrxmlOut);

		JasperCompileManager.compileReportToFile(inputFileJasperSub, compiledFileJasperSub);
		JasperCompileManager.compileReportToFile(inputFileJasperOut, compiledFileJasper);
		
		return compiledFileJasper;
	}

	public void exportXLSReport(String inputFileJasper, String inputFileJasperSub, List<?> dataSourceObjectsList, Map<String, Object> parameters, ByteArrayOutputStream os) throws Exception {

		String compiledFileJasper;
		try {
			compiledFileJasper = compile(inputFileJasper, inputFileJasperSub);
		}
		catch (Exception e) {
			throw new ReportingException("An error has occured while compiling " + inputFileJasper + " sub : " + inputFileJasperSub, e);
		}
		
		try {
			
			JRDataSource jrds;
			if ( dataSourceObjectsList == null ) {
				jrds = new JREmptyDataSource();
			} else {
				jrds = new JRBeanCollectionDataSource(dataSourceObjectsList);
			}
			JasperReport template = (JasperReport) JRLoader.loadObjectFromFile( compiledFileJasper );
			JasperPrint report = JasperFillManager.fillReport(template, parameters, jrds);

			JRXlsExporter xlsExporter = new JRXlsExporter();
			xlsExporter.setParameter(JRExporterParameter.OFFSET_X, new Integer(-30));
			xlsExporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 0);
			xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			xlsExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, report);
				
			xlsExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, os);
			xlsExporter.exportReport();
		} catch (Exception e) {
			throw new ReportingException("An error has accured during report generation !", e);
		}
	}

}
