/**
 * 
 */
package in.ashokit.bindings.request;

import lombok.Data;

/**
 * @author USER
 *
 */
@Data
public class SearchRequest {
	private String planName;
	private String planStatus;
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

}
