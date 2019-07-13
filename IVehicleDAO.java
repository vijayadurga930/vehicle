package com.cg.vms.dao;

import java.util.Map;

import com.cg.vms.exceptions.VMSException;
import com.cg.vms.model.Vehicle;

public interface IVehicleDAO {

	public int addVehicle(Vehicle vehicle) throws VMSException;

	public Map<Integer, Vehicle> getAllVehicles() throws VMSException;

}
