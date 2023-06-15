package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Course;
import de.tum.in.ase.pse.view.CourseDetailView;
import de.tum.in.ase.pse.view.CourseListView;

public class Controller {

	private CourseListView courseListView;
	// HINT: Instantiate courseDetailView in selectCourse, don't make this a local variable
	private CourseDetailView courseDetailView;

	// TODO: Implement saveCourse(). This method should add the course to the list view and notify the observers
	public void saveCourse(Course c) {
		courseListView.addCourse(c);
		c.notifyObservers();
	}
	// TODO: Implement selectCourse(). This method should initialize courseDetailView and display it
	public void selectCourse(Course c) {
		courseDetailView = new CourseDetailView(this, c);
		courseDetailView.show();
	}
	public void setCourseListView(CourseListView courseListView) {
		this.courseListView = courseListView;
	}
}
