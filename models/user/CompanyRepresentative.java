package models.user;

public class CompanyRepresentative extends User {
	private String company;
	private String status = "Pending";

	public CompanyRepresentative(String name, String passwordHash, String company) {
		super(name, passwordHash);

		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
