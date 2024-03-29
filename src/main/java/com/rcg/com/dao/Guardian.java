package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ryg_guardian")
public class Guardian 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="guardian_id")
	private int guardianId;
	
	private int cabin;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	private String language;
	private String nationality;

	@Column(name="ship_code")
	private String shipCode;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	private Date created;
	private Date updated;

	@Column(name="booking_id")
	private long bookingID;
	
	@Column(name="folio_id")
	private long folioID;
	
	private char gender;
	
	@Column(name="passenger_type")
	private char passengerType;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="contact_number")
	private String contectNumber;
	
	@ManyToMany
	@Column(name = "young_gust")
	private Set<YoungGust> youngGust;
	
	@Column(name="image_url")
	private String imageUrl;
	
	
	public Guardian() 
	{
		super();
	}



	public Guardian(int guardianId) 
	{
		super();
		this.guardianId = guardianId;
	}



	public int getGuardianId() {
		return guardianId;
	}



	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
	}



	public int getCabin() {
		return cabin;
	}



	public void setCabin(int cabin) {
		this.cabin = cabin;
	}



	public int getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}



	public int getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public String getShipCode() {
		return shipCode;
	}



	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public Date getUpdated() {
		return updated;
	}



	public void setUpdated(Date updated) {
		this.updated = updated;
	}



	public long getBookingID() {
		return bookingID;
	}



	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}



	public long getFolioID() {
		return folioID;
	}



	public void setFolioID(long folioID) {
		this.folioID = folioID;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public char getPassengerType() {
		return passengerType;
	}



	public void setPassengerType(char passengerType) {
		this.passengerType = passengerType;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Set<YoungGust> getYoungGust() {
		return youngGust;
	}



	public void setYoungGust(Set<YoungGust> youngGust) {
		this.youngGust = youngGust;
	}



	public String getContectNumber() {
		return contectNumber;
	}



	public void setContectNumber(String contectNumber) {
		this.contectNumber = contectNumber;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
