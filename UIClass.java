package com.cg.vms.presentation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.cg.vms.exceptions.VMSException;
import com.cg.vms.model.Vehicle;
import com.cg.vms.service.IVehicleService;
import com.cg.vms.service.VehicleServiceImpl;

public class UIClass {

	public static void main(String[] args) {

		String continueChoice;
		boolean continueValue = false;

		Scanner scanner = null;
		do {

			System.out.println("*** welcome to vehicle Application");
			System.out.println("1.Add vehicle");
			System.out.println("2.get vehicle details");
			System.out.println("3.display all vehicles");
			System.out.println("4.delete vehicle");
			System.out.println("5.exit");

			IVehicleService service = new VehicleServiceImpl();

			int choice = 0;
			boolean choiceFlag = false;

			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter input:");
				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					boolean vehicleNameFlag = false;

					String vehicleName = "";
					switch (choice) {

					case 1:
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter Vehicle name:");
							vehicleName = scanner.nextLine();
							try {
								service.validateVehicleName(vehicleName);
								vehicleNameFlag = true;
							} catch (VMSException e) {
								vehicleNameFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!vehicleNameFlag);

						double vehicleCost = 0;
						boolean vehicleCostFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter vehicle Cost:");
							try {
								vehicleCost = scanner.nextDouble();
								service.validateCost(vehicleCost);
								vehicleCostFlag = true;
							} catch (InputMismatchException e) {
								vehicleCostFlag = false;
								System.err.println("Cost should be in digits");
							} catch (VMSException e) {
								vehicleCostFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!vehicleCostFlag);

						scanner.nextLine();
						System.out.println("Enter company:");
						String company = scanner.nextLine();

						Vehicle vehicle = new Vehicle(vehicleName, vehicleCost, company);

						try {
							int genearatedId = service.addVehicle(vehicle);
							System.out.println("vehicle stored with the given id: " + genearatedId);
						} catch (VMSException e) {
							System.err.println(e.getMessage());
						}

						break;

					case 2:

						break;

					case 3:

						try {
							Map<Integer, Vehicle> vehicles = service.getAllVehicles();

							Iterator<Integer> iterator = vehicles.keySet().iterator();
							while (iterator.hasNext()) {
								int id = iterator.next();
								Vehicle vehicleData = vehicles.get(id);
								System.out.println(id + ": " + vehicleData);
							}

						} catch (VMSException e) {
							System.err.println(e.getMessage());
						}

						break;

					case 5:
						System.out.println("Thank u, visit again");
						System.exit(0);
						break;
					default:
						System.out.println("input should be 1,2,3,4 or 5");
						choiceFlag = false;
						break;
					}

				} catch (InputMismatchException exception) {
					choiceFlag = false;
					System.err.println("input should contain only digits");
				}
			} while (!choiceFlag);

			do {
				scanner = new Scanner(System.in);
				System.out.println("do you want to continue again [yes/no]");
				continueChoice = scanner.nextLine();
				if (continueChoice.equalsIgnoreCase("yes")) {
					continueValue = true;
					break;
				} else if (continueChoice.equalsIgnoreCase("no")) {
					System.out.println("thank you");
					continueValue = false;
					break;
				} else {
					System.out.println("enter yes or no");
					continueValue = false;
					continue;
				}
			} while (!continueValue);

		} while (continueValue);
		scanner.close();
	}

}
