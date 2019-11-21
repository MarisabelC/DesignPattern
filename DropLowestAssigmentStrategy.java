package ClassCourses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.management.InvalidAttributeValueException;


public class DropLowestAssigmentStrategy extends AverageStrategy{
	
	@Override
	public double getAverage(Student student) {
				
		Iterator<Double> assigmentScore = removeLowest(student.getAssigmentScoreIterator());
		return getAverageAssignmentScore(assigmentScore) + getAverageExamScore(student.getExamScoreIterator());
				
	}
	
	private Iterator<Double> removeLowest(Iterator<Double> scores){
		List<Double> result = new ArrayList<>(); 
		while (scores.hasNext()) 
			result.add( scores.next() );
		Collections.sort(result);
		result.remove(0);
		
		return result.iterator(); 
	}
}
