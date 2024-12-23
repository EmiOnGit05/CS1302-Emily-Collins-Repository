package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TaskManager for managing a list of tasks.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class TaskManager implements Collection<Task> {
	
	private List<Task> taskList;
	private Map<String, Task> taskMap;
	
	/**
	 * Constructor for TaskManager.
	 * 
	 * @precondition none
	 * @postcondition this.taskList = new ArrayList/Task/ &&
	 * this.taskMap = new HashMap/String, Task/
	 */
	public TaskManager() {
		this.taskList = new ArrayList<Task>();
		this.taskMap = new HashMap<String, Task>();
	}
	
	/**
	 * Getter for this.taskList
	 * 
	 * @return this.taskList
	 */
	public List<Task> getTaskList() {
		return this.taskList;
	}
	
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
			if (this.taskMap.containsKey(task.getTitle())) {
				throw new IllegalArgumentException("Cannot add a duplicate task!");
			} else {
				this.taskMap.put(task.getTitle(), task);
				return this.taskList.add(task);
			}
		}
	}

	@Override
	public boolean remove(Object task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null! Please try again");
		} else {
			this.taskMap.remove(((Task) task).getTitle());
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
			boolean changed = false;
			for (Task task : tasks) {
				if (this.add(task)) {
					changed = true;
				}
			}
			return changed;
		}
	}

	@Override
	public boolean removeAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			boolean changed = false;
			for (Object task : tasks) {
				if (this.remove(task)) {
					changed = true;
				}
			}
			return changed;
		}
	}

	@Override
	public boolean retainAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void clear() {
		this.taskList.clear();
	}

}
