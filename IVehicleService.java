package com.cg.vms.service;

import java.util.Map;

import com.cg.vms.exceptions.VMSException;
import com.cg.vms.model.Vehicle;

public interface IVehicleService {

	public boolean validateVehicleName(String vehicleName) throws VMSException;

	public boolean validateCost(double vehicleCost) throws VMSException;

	public int addVehicle(Vehicle vehicle) throws VMSException;

	public Map<Integer, Vehicle> getAllVehicles() throws VMSException;

}
