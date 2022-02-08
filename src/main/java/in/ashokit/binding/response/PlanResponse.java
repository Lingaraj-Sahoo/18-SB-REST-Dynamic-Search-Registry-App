/**
 * 
 */
package in.ashokit.binding.response;

import lombok.Data;

/**
 * @author USER
 *
 */
@Data
public class PlanResponse {
	
	private Integer planId;
	private String planName;
	private String planHolderName;
	private Long planHolderSsn;
	private String planStatus;
	
	
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanHolderName() {
		return planHolderName;
	}
	public void setPlanHolderName(String planHolderName) {
		this.planHolderName = planHolderName;
	}
	public Long getPlanHolderSsn() {
		return planHolderSsn;
	}
	public void setPlanHolderSsn(Long planHolderSsn) {
		this.planHolderSsn = planHolderSsn;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
}
