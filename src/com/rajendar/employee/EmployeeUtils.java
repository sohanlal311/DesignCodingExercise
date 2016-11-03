package com.rajendar.employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

	public static List<Employee> readEmployeeDataFromFile(String fileName)
			throws IOException {
		List<Employee> empList = new ArrayList<Employee>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			while ((line = reader.readLine()) != null) {
				String data[] = line.trim().split(",");

				Employee emp = new Employee();
				emp.setId(data[0]);
				emp.setName(data[1]);
				emp.setAge(Integer.valueOf(data[2]));
				emp.setSalary(Double.valueOf(data[3]));
				if (data.length == 5) {
					emp.setMgrId(data[4]);
				} else {
					emp.setMgrId("");
				}
				empList.add(emp);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return empList;
	}

	public static EmployeeTreeNode buildEmployeeTree(List<Employee> empList) {
		EmployeeTreeNode head = new EmployeeTreeNode(empList.get(0));

		for (int i = 1; i < empList.size(); i++) {
			Employee employee = empList.get(i);
			addToTree(head, employee);
		}
		return head;
	}

	private static boolean addToTree(EmployeeTreeNode node, Employee emp) {
		if (node == null) {
			return false;
		}

		if (emp.getMgrId().equals(node.getEmployee().getId())) {
			node.addChild(emp);
			return true;
		}

		if (node.getChildren() != null) {
			for (EmployeeTreeNode childNode : node.getChildren()) {
				if (addToTree(childNode, emp)) {
					return true;
				}
			}
		}

		return false;
	}
}
