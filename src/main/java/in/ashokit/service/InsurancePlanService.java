/**
 * 
 */
package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.response.PlanResponse;
import in.ashokit.bindings.request.SearchRequest;

/**
 * @author USER
 *
 */
public interface InsurancePlanService {
	
	public List<PlanResponse> searchPlan(SearchRequest request);
	
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatus();

}
