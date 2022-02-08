/**
 * 
 */
package in.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author USER
 *
 */
@Entity
@Table(name="INSURANCE_PLANS")
@Data
public class InsurancePlanEntity {
	
	@Id
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_HOLDER_NAME")
	private String planHolderName;
	
	@Column(name="PLAN_HOLDER_SSN")
	private Long planHolderSsn;
	
	@Column(name="PLAN_STATUS")
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
