package ClassCourses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Roster {
	private String name;
	private String number;
	private List<Student> students;
	
	public Roster(String name, String number){
		this.name = name;
		this.number= number;
		students = new ArrayList<>();
	}
	
	public String getCourseName() {
		return name;
	}
	
	public void addStudent (Student student) {
		students.add(student);
	}

	public AverageIterator getAverageList() {
		return new AverageIterator(this);
	}

	public Iterator<Student> getStudentList(){
		return students.iterator();
	}

}
