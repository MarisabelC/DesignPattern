package ClassCourses;

import java.text.DecimalFormat;

public class Courses {

	public static void main(String[] args) {
		Student student = new Student("Bob");
		student.addAssignmentScore(98.5);
		student.addAssignmentScore(100);
		student.addAssignmentScore(80);
		student.addExamScore(95);
		student.addExamScore(87);

		DecimalFormat df = new DecimalFormat("0.0");
		// should use algorithm A by default:
		System.out.println(student.getName() + "'s average: " +
				df.format(student.getAverage()));

		// switch to algorithm B:
		student.setDropLowestAssign(true);
		System.out.println("Drop lowest assigment. " +student.getName() + "'s average: " +
				df.format(student.getAverage()));
		// switch back to algorithm A:
		student.setDropLowestAssign(false);
		System.out.println(student.getName() + "'s average: " +
				df.format(student.getAverage()));

		//test the GradeTracker
		GradeTrackerObserver gt = new GradeTrackerObserver(student);
		System.out.println("letter grade: " + gt.getLetterGrade());
		student.addExamScore(33);
		System.out.println("Added an exam score.");
		System.out.println("letter grade: " + gt.getLetterGrade());

		//add a new student
		Student hg = new Student("Alice");
		hg.addAssignmentScore(92.2);
		hg.addAssignmentScore(98.1);
		hg.addAssignmentScore(97.3);
		hg.addExamScore(95);
		hg.addExamScore(97);

		//new roster
		Roster potions = new Roster("Calculus","Cal1008");
		potions.addStudent(student);
		potions.addStudent(hg);

		//test the roster traversal
		System.out.println("Calculus grades:");
		AverageIterator ad = potions.getAverageList();
		while (ad.hasNext()) {
			System.out.println("next average "  +
					df.format(ad.next()));
		}

	}

}
