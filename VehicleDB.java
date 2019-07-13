package com.cg.vms.utility;

import java.util.Map;
import java.util.TreeMap;

import com.cg.vms.model.Vehicle;

public class VehicleDB {

	private static Map<Integer, Vehicle> vehicles = new TreeMap<>();

	static {

		vehicles.put(111, new Vehicle("Activa", 65000, "Honda"));
		vehicles.put(222, new Vehicle("Access", 55000, "Suzuki"));
		vehicles.put(333, new Vehicle("Unicorn", 95000, "Honda"));
		vehicles.put(444, new Vehicle("Jupiter", 76000, "TVS"));
		vehicles.put(555, new Vehicle("Apache", 85000, "TVS"));
	}

	public static Map<Integer, Vehicle> getVehicles() {
		return vehicles;
	}

	public static void setVehicles(Map<Integer, Vehicle> vehicles) {
		VehicleDB.vehicles = vehicles;
	}

}
