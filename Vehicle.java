package com.cg.vms.model;

public class Vehicle {

	private int vehicleId;
	private String vehicleName;
	private double vehicleCost;
	private String company;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleName, double vehicleCost, String company) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleCost = vehicleCost;
		this.company = company;
	}

	public Vehicle(int vehicleId, String vehicleName, double vehicleCost, String company) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleCost = vehicleCost;
		this.company = company;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getVehicleCost() {
		return vehicleCost;
	}

	public void setVehicleCost(double vehicleCost) {
		this.vehicleCost = vehicleCost;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Vehicle [ vehicleName=" + vehicleName + ", vehicleCost=" + vehicleCost
				+ ", company=" + company + "]";
	}

}
