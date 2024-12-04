package edu.westga.cs1302.project3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * TaskManager for managing a list of tasks.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class TaskManager implements Collection<Task> {
	
	private Map<String, Task> taskList;
	
	public TaskManager() {
		this.taskList = new HashMap<String, Task>();
	}
	
	public Map<String, Task> getTaskList() {
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
			return this.taskList.containsValue(task);
		}
	}

	@Override
	public Iterator<Task> iterator() {
		return this.taskList.values().iterator();
	}

	@Override
	public Object[] toArray() {
		return this.taskList.values().toArray();
	}

	@Override
	public <T> T[] toArray(T[] tasks) {
		return this.taskList.values().toArray(tasks);
	}

	@Override
	public boolean add(Task task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null! Please try again");
		} else {
			return this.taskList.put(task.getTitle(), task) == null;
		}
	}

	@Override
	public boolean remove(Object task) {
		if (task == null) {
			throw new NullPointerException("Task cannot be null! Please try again");
		} else {
			return this.taskList.remove(((Task) task).getTitle(), task);
		}
	}

	@Override
	public boolean containsAll(Collection<?> tasks) {
		if (tasks == null) {
			throw new NullPointerException("Tasks cannot be null!");
		} else if (tasks.contains(null)) {
			throw new NullPointerException("Tasks cannot contain null!");
		} else {
			for (Object task : tasks) {
				if (this.taskList.get(((Task)task).getTitle()) == null) {
					return false;
				}
			}
			return true;
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
