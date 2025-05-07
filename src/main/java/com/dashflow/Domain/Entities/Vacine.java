package com.dashflow.Domain.Entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Vacine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String name;
	private LocalDateTime dayTaken;
	private LocalDateTime expirationDate;
	private Duration duration;
	private Integer dose = 1;
	private Hospital hostHospital;
	
	public Vacine() {
		this.id = new ObjectId().toString();
	}

	public Vacine(String name, LocalDateTime expirationDate, Hospital hostHospital) {
		this.id = new ObjectId().toString();
		this.name = name;
		this.dayTaken = LocalDateTime.now();
		this.expirationDate = expirationDate;
		this.dose = 1;
		this.duration = Duration.between(dayTaken, expirationDate);
		this.hostHospital = hostHospital;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getDayTaken() {
		return dayTaken;
	}
	
	public void setDayTaken(LocalDateTime dayTaken) {
		this.dayTaken = dayTaken;
	}
	
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Hospital getHostHospital() {
		return hostHospital;
	}
	
	public void setHostHospital(Hospital hostHospital) {
		this.hostHospital = hostHospital;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}
}
