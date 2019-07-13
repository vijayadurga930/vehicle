package com.cg.vms.service;

import java.util.Map;
import java.util.regex.Pattern;

import com.cg.vms.dao.IVehicleDAO;
import com.cg.vms.dao.VehicleDaoImpl;
import com.cg.vms.exceptions.VMSException;
import com.cg.vms.model.Vehicle;

public class VehicleServiceImpl implements IVehicleService {

	IVehicleDAO vehicleDao = new VehicleDaoImpl();

	@Override
	public boolean validateVehicleName(String vehicleName) throws VMSException {

		boolean resultFlag = false;
		String nameRegEx = "[A-Z]{1}[a-zA-Z ]{4,}";

		if (!Pattern.matches(nameRegEx, vehicleName)) {
			throw new VMSException("first letter should be capital and length should be gt 5");
		} else {
			resultFlag = true;
		}
		return resultFlag;
	}

	@Override
	public boolean validateCost(double vehicleCost) throws VMSException {

		boolean costFlag = false;

		if (vehicleCost < 50000) {
			throw new VMSException("cost should not be lt 50000");
		} else {
			costFlag = true;
		}
		return costFlag;

	}

	@Override
	public int addVehicle(Vehicle vehicle) throws VMSException {
		return vehicleDao.addVehicle(vehicle);
	}

	@Override
	public Map<Integer, Vehicle> getAllVehicles() throws VMSException {
		return vehicleDao.getAllVehicles();

	}

}
