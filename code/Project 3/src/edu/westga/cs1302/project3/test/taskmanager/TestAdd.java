package edu.westga.cs1302.project3.test.taskmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestAdd {

	@Test
	void testNullTask() {
		TaskManager manager = new TaskManager();
		assertThrows(NullPointerException.class, () -> {
			manager.add(null);
		});
	}
	
	@Test
	void testDuplicateTask() {
		Task task = new Task("Title", "Description");
		Task taskTwo = new Task("Title2", "Description2");
		Task taskThree = new Task("Title2", "Description3");
		TaskManager manager = new TaskManager();
		manager.add(task);
		manager.add(taskTwo);
		assertThrows(IllegalArgumentException.class, () -> {
			manager.add(taskThree);
		});
	}
	
	@Test
	void testValidAdd() {
		Task task = new Task("Title", "Description");
		Task taskTwo = new Task("Title2", "Description2");
		Task taskThree = new Task("Title3", "Description3");
		TaskManager manager = new TaskManager();
		manager.add(task);
		manager.add(taskTwo);
		manager.add(taskThree);
		assertEquals(task, manager.getTaskList().get(0));
		assertEquals(taskTwo, manager.getTaskList().get(1));
		assertEquals(taskThree, manager.getTaskList().get(2));
	}

}
