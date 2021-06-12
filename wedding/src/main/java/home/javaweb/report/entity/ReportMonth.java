package home.javaweb.report.entity;

import java.time.Month;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "report_month")
public class ReportMonth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int year;
	
	private int month;
	
	private Long revenue;
	
	@OneToMany(mappedBy = "reportMonth")
	private Set<ReportDate> reportsDate = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public Set<ReportDate> getReportsDate() {
		return reportsDate;
	}

	public void setReportsDate(Set<ReportDate> reportsDate) {
		this.reportsDate = reportsDate;
	}
	
	
}
