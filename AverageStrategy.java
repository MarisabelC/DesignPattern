package ClassCourses;

import java.util.Iterator;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class AverageStrategy {
	
	
	public double getAverage(Student student)  {
		
		return getAverageAssignmentScore(student.getAssigmentScoreIterator()) + getAverageExamScore(student.getExamScoreIterator());
	}

	private double sumAllScores(Iterator<Double> scores, double percentage) {
		double total=0;
		int count=0;
		
		while (scores.hasNext()) {
			total += scores.next();
			count++;
		}
		
		total = total / count * percentage;
		
		return total;
	}
	
	protected double getAverageAssignmentScore(Iterator<Double> assigmentScores) {
		double assigmentPercent= 0.40;
		return  sumAllScores(assigmentScores, assigmentPercent);
	}
	
	protected double getAverageExamScore(Iterator<Double> assigmentScores) {
		double assigmentPercent= 0.60;
		return  sumAllScores(assigmentScores, assigmentPercent);
	}
	
	
}
