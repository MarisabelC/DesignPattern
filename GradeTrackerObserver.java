package ClassCourses;

import java.util.Observable;
import java.util.Observer;

import javax.management.InvalidAttributeValueException;

public class GradeTrackerObserver implements Observer{

	private char letterGrade;
	
	public GradeTrackerObserver(Student student) {
		student.addObserver(this);
		letterGrade = student.getLetterGrade();
		
	}
	
	public char getLetterGrade() {
		return letterGrade;
	}


	@Override
	public void update(Observable o, Object arg) {
		Student student= (Student) o;
		letterGrade = student.getLetterGrade();
	}

}
