package home.javaweb.report.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import home.javaweb.bill.entity.Bill;

@Entity
@Table(name= "report_date")
public class ReportDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDate date;
	
	@Column(name = "feast_count")
	private int feastCount;
	
	private Long revenue;
	
	private Float ratio;
	
	@ManyToOne
	@JoinColumn(name = "report_month_id")
	private ReportMonth reportMonth;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "report_date_detail",
			joinColumns = @JoinColumn(name = "report_date_id"),
			inverseJoinColumns = @JoinColumn(name = "bill_id")		
	)
	private Set<Bill> bills = new HashSet<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getFeastCount() {
		return feastCount;
	}

	public void setFeastCount(int feastCount) {
		this.feastCount = feastCount;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public Float getRatio() {
		return ratio;
	}

	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public ReportMonth getReportMonth() {
		return reportMonth;
	}

	public void setReportMonth(ReportMonth reportMonth) {
		this.reportMonth = reportMonth;
	}
	
	
}
