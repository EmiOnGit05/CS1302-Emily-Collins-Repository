package edu.westga.cs1302.project3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestViewModelAddTask {

	@Test
	void testAddTask() {
		TaskManager manager = new TaskManager();
		Task taskOne = new Task("Clean the dishes", "Unloading the dishwasher and loading it again.");
		Task taskTwo = new Task("Do the laundry", "Switching over to the dryer, starting a new load, and putting away the finished load.");
		manager.add(taskOne);
		manager.add(taskTwo);
		assertEquals(2, manager.getTaskList().size());
		assertEquals(taskOne, manager.getTaskList().get(0));
		assertEquals(taskTwo, manager.getTaskList().get(1));
	}

}
