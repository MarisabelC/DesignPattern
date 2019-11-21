package ClassCourses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import javax.management.InvalidAttributeValueException;

public class Student extends Observable {
	
	private String name;
	private List<Double> assigmentScores;
	private List<Double> examScores;
	private AverageStrategy averageType;
	
	
	public Student(String name) {
		this.name = name;
		assigmentScores = new ArrayList<>();
		examScores = new ArrayList<>();
		averageType = new AverageStrategy();
	}
	
	
   	public void addAssignmentScore (double assigmentScore) {
   		assigmentScores.add(assigmentScore);
   		setChanged();
   		notifyObservers();
   	}
   	
   	public void addExamScore (double examScore) {
   		examScores.add(examScore);
   		setChanged();
   		notifyObservers();
   	}

	public String getName() {
		return name;
	}
	
	public int getNumberAssignment() {
		return assigmentScores.size();
	}
	
	public Iterator<Double> getAssigmentScoreIterator() {
		return assigmentScores.iterator();
	}

	public Iterator<Double> getExamScoreIterator() {
		return examScores.iterator();
	}

	public char getLetterGrade()  {
		
		double grade= getAverage();
		char letterGrade='F';
		
		if (grade>=90)
			letterGrade = 'A';
		else if (grade>=80)
			letterGrade = 'B';
		else if (grade>=70)
			letterGrade = 'C';
		else if (grade>=60)
			letterGrade = 'D';
			
		return letterGrade;
	}
	
	public double getAverage() {
		return averageType.getAverage(this);
	}
	
	public void setDropLowestAssign(boolean dropLowest) {
		if (dropLowest == true )
			averageType = new DropLowestAssigmentStrategy();
		else 
			averageType = new AverageStrategy();
			
	}
	
	

	
}
