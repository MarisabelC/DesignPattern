package ClassCourses;

import java.util.Iterator;

import javax.management.InvalidAttributeValueException;

public class AverageIterator implements Iterator<Double>{

	private Iterator<Student> studentIterator; 
	
	public AverageIterator(Roster roster) {
		this.studentIterator = roster.getStudentList();
	}
	


	@Override
	public boolean hasNext() {
		return studentIterator.hasNext();
	}

	@Override
	public Double next() {
		
		Student student = studentIterator.next();
		return student.getAverage();
	}

}
