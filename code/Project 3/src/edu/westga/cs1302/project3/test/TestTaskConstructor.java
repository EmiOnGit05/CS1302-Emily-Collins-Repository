package edu.westga.cs1302.project3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

class TestTaskConstructor {

	@Test
	void testTitleNull() {
		assertThrows(NullPointerException.class, () -> {
			new Task(null, "description");
		});
	}
	
	@Test
	void testDescriptionNull() {
		assertThrows(NullPointerException.class, () -> {
			new Task("Title", null);
		});
	}
	
	@Test
	void testTitleEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "description");
		});
	}
	
	@Test
	void testDescriptionEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Title", "");
		});
	}
	
	@Test
	void testValidConstructor() {
		Task task = new Task("Title", "Description");
		assertEquals("Title", task.getTitle());
		assertEquals("Description", task.getDescription());
	}

}
