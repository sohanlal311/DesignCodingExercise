package com.rajendar.employee;

import java.io.IOException;
import java.util.List;

public class EmployeeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		final String fileName = "data/EmployeeData.txt";
		List<Employee> list = EmployeeUtils.readEmployeeDataFromFile(fileName);
		EmployeeTreeNode head = EmployeeUtils.buildEmployeeTree(list);
		EmployeeTreeNode.printTree(head);
	}
}
