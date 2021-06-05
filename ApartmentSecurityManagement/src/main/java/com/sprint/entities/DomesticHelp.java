package com.sprint.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "domestic_help_asm")
public class DomesticHelp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="dhelp_attendance",joinColumns = @JoinColumn(name = "domestic_help_id"))
	private List<Attendance> attendance;
	
	@Enumerated(EnumType.STRING)
	private DomesticHelpType helpType;
	
	private String name;
	
	private String aadharId;
	
	private String mobileNumber;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FlatDetails> flatDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public DomesticHelpType getHelpType() {
		return helpType;
	}

	public void setHelpType(DomesticHelpType helpType) {
		this.helpType = helpType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<FlatDetails> getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(List<FlatDetails> flatDetails) {
		this.flatDetails = flatDetails;
	}

	public DomesticHelp(List<Attendance> attendance, DomesticHelpType helpType, String name, String aadharId,
			String mobileNumber, List<FlatDetails> flatDetails) {
		super();
		this.attendance = attendance;
		this.helpType = helpType;
		this.name = name;
		this.aadharId = aadharId;
		this.mobileNumber = mobileNumber;
		this.flatDetails = flatDetails;
	}

	public DomesticHelp(Long id, List<Attendance> attendance, DomesticHelpType helpType, String name, String aadharId,
			String mobileNumber, List<FlatDetails> flatDetails) {
		super();
		this.id = id;
		this.attendance = attendance;
		this.helpType = helpType;
		this.name = name;
		this.aadharId = aadharId;
		this.mobileNumber = mobileNumber;
		this.flatDetails = flatDetails;
	}

	public DomesticHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DomesticHelp [id=" + id + ", attendance=" + attendance + ", helpType=" + helpType + ", name=" + name
				+ ", aadharId=" + aadharId + ", mobileNumber=" + mobileNumber + ", flatDetails=" + flatDetails + "]";
	}
}
