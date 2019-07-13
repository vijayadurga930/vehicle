package com.cg.vms.dao;

import java.util.Map;

import com.cg.vms.exceptions.VMSException;
import com.cg.vms.model.Vehicle;
import com.cg.vms.utility.VehicleDB;

public class VehicleDaoImpl implements IVehicleDAO {

	@Override
	public int addVehicle(Vehicle vehicle) throws VMSException {

		Map<Integer, Vehicle> map = VehicleDB.getVehicles();

		double randomNumber = Math.random() * 1000;

		int generatedId = (int) randomNumber;

		map.put(generatedId, vehicle);

		return generatedId;
	}

	@Override
	public Map<Integer, Vehicle> getAllVehicles() throws VMSException {

		return VehicleDB.getVehicles();
	}

}
