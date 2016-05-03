package br.com.eshopper.ecommerce.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SummaryUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String OBJECT_KEY = "SummaryUser";
	
	public static final String OBJECT_ID = "Users";
	
	private String id;
	private Long totalGeneralUsers;
	private Long totalMaleUsers;
	private Long totalFemaleUsers;
	private Long totalChildUsers;
	
	public String getId() {
		return OBJECT_ID.toLowerCase();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getTotalGeneralUsers() {
		return totalGeneralUsers;
	}

	public void setTotalGeneralUsers(Long totalGeneralUsers) {
		this.totalGeneralUsers = totalGeneralUsers;
	}

	public Long getTotalMaleUsers() {
		return totalMaleUsers;
	}

	public void setTotalMaleUsers(Long totalMaleUsers) {
		this.totalMaleUsers = totalMaleUsers;
	}

	public Long getTotalFemaleUsers() {
		return totalFemaleUsers;
	}

	public void setTotalFemaleUsers(Long totalFemaleUsers) {
		this.totalFemaleUsers = totalFemaleUsers;
	}

	public Long getTotalChildUsers() {
		return totalChildUsers;
	}

	public void setTotalChildUsers(Long totalChildUsers) {
		this.totalChildUsers = totalChildUsers;
	}

	@Override
	public String toString() {
		return "SummaryUser [id=" + id + ", totalGeneralUsers=" + totalGeneralUsers + ", totalMaleUsers="
				+ totalMaleUsers + ", totalFemaleUsers=" + totalFemaleUsers + ", totalChildUsers=" + totalChildUsers
				+ "]";
	}
	
}
