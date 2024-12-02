package edu.westga.cs1302.project3.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * TaskManager for managing a list of tasks.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class TaskManager implements Collection<Task> {
	
	private String title;
	private List<Task> taskList;
	
	@Override
	public int size() {
		return this.taskList.size();
	}

	@Override
	public boolean isEmpty() {
		return this.taskList.isEmpty();
	}

	@Override
	public boolean contains(Object task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null!");
		} else {
			return this.taskList.contains(task);
		}
	}

	@Override
	public Iterator<Task> iterator() {
		return this.taskList.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.taskList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] tasks) {
		return this.taskList.toArray(tasks);
	}

	@Override
	public boolean add(Task task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null! Please try again");
		} else {
			return this.taskList.add(task);
		}
	}

	@Override
	public boolean remove(Object task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null! Please try again");
		} else {
			return this.taskList.remove(task);
		}
	}

	@Override
	public boolean containsAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			return this.taskList.containsAll(tasks);
		}
	}

	@Override
	public boolean addAll(Collection<? extends Task> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			return this.taskList.addAll(tasks);
		}
	}

	@Override
	public boolean removeAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			return this.taskList.removeAll(tasks);
		}
	}

	@Override
	public boolean retainAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			return this.taskList.retainAll(tasks);
		}
	}

	@Override
	public void clear() {
		this.taskList.clear();
	}

}
