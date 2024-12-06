package edu.westga.cs1302.project3.test.taskmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestRemove {

	@Test
	void testNullTask() {
		TaskManager manager = new TaskManager();
		assertThrows(NullPointerException.class, () -> {
			manager.remove(null);
		});
	}
	
	@Test
	void testValidRemove() {
		Task task = new Task("Title", "Description");
		Task taskTwo = new Task("Title2", "Description2");
		Task taskThree = new Task("Title3", "Description3");
		TaskManager manager = new TaskManager();
		manager.add(task);
		manager.add(taskTwo);
		manager.add(taskThree);
		manager.remove(taskTwo);
		assertEquals(task, manager.getTaskList().get(0));
		assertEquals(taskThree, manager.getTaskList().get(1));
	}

}
