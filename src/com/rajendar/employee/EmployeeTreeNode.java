package com.rajendar.employee;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is used to store employee data in a Tree Node.
 */
public class EmployeeTreeNode {

	private Employee employee;

	private Set<EmployeeTreeNode> children;

	public EmployeeTreeNode(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Set<EmployeeTreeNode> getChildren() {
		return children;
	}

	public void addChild(Employee e) {
		if (children == null) {
			children = new TreeSet<EmployeeTreeNode>(
					new EmployeeNodeComparator());
		}
		EmployeeTreeNode node = new EmployeeTreeNode(e);
		children.add(node);
	}

	public int getAvgSalary() {
		int avgSalary = 0;
		if (children != null) {
			int count = 0, sum = 0;
			for (EmployeeTreeNode node : children) {
				sum += node.getEmployee().getSalary();
				count++;
			}
			avgSalary = sum / count;
		}
		return avgSalary;
	}

	public static void printTree(EmployeeTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.format("%s %10s", node.getEmployee(), node.getAvgSalary());
		System.out.println();

		if (node.getChildren() != null) {
			for (EmployeeTreeNode childNode : node.getChildren()) {
				printTree(childNode);
			}
		}
	}

	/**
	 * This class is used to decide sorting order of Employee objects.
	 */
	private static class EmployeeNodeComparator implements
			Comparator<EmployeeTreeNode> {

		@Override
		public int compare(EmployeeTreeNode node1, EmployeeTreeNode node2) {
			if (node1 == null || node2 == null) {
				throw new IllegalArgumentException();
			}
			return node1.getEmployee().getId()
					.compareTo(node2.getEmployee().getId());
		}

	}

}
