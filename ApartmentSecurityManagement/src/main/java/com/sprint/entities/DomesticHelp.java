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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@NotBlank(message = "Name Required")
	private String name;
	
	@NotBlank(message = "Id Required")
	private String aadharId;
	
	@NotNull(message = "Mobile Number Required")
	private Long mobileNumber;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "dhelp_flat")
	private FlatDetails flatDetails;

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

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public FlatDetails getFlatDetails() {
		return flatDetails;
	}

	public void setFlatDetails(FlatDetails flatDetails) {
		this.flatDetails = flatDetails;
	}

	public DomesticHelp(List<Attendance> attendance, DomesticHelpType helpType, String name, String aadharId,
			Long mobileNumber, FlatDetails flatDetails) {
		super();
		this.attendance = attendance;
		this.helpType = helpType;
		this.name = name;
		this.aadharId = aadharId;
		this.mobileNumber = mobileNumber;
		this.flatDetails = flatDetails;
	}

	public DomesticHelp(Long id, List<Attendance> attendance, DomesticHelpType helpType, String name, String aadharId,
			Long mobileNumber, FlatDetails flatDetails) {
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
