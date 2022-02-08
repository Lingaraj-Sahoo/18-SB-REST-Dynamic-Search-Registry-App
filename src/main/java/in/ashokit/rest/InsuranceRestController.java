/**
 * 
 */
package in.ashokit.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.response.PlanResponse;
import in.ashokit.bindings.request.SearchRequest;
import in.ashokit.reports.ExcelReportGenerator;
import in.ashokit.reports.PDFReportGenerator;
import in.ashokit.service.InsurancePlanService;

/**
 * @author USER
 *
 */
@RestController
public class InsuranceRestController {
	
	@Autowired
	private InsurancePlanService service;
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attacment; filename=plans_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans = service.searchPlan(null);
		PDFReportGenerator pdfReport = new PDFReportGenerator();
		pdfReport.exportPdf(plans, response);
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attacment; filename=plans_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<PlanResponse> plans = service.searchPlan(null);
		ExcelReportGenerator excelReport = new ExcelReportGenerator();
		excelReport.export(plans, response);
	}
	

	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> searchPlans(@RequestBody SearchRequest request){
		List<PlanResponse> searchPlans = service.searchPlan(request);
		return new ResponseEntity<>(searchPlans, HttpStatus.OK);
	}
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> planNames = service.getUniquePlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getPlanStatus() {
		List<String> planStatus = service.getUniquePlanStatus();
		return new ResponseEntity<>(planStatus, HttpStatus.OK);
	}
}
