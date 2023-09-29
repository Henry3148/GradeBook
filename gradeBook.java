import java.util.*;
public class gradeBook {
	public static Double getGPA(ArrayList <ArrayList <String>> classes){
		double denominator = 0;
		double numerator = 0;
		double gradeRef;
		double gradeTotal = 0;
		int count = 0;

		for (int i = 0; i < classes.size(); i++) {
			for (int j = 1; j < classes.get(i).size(); j = j+2){
				numerator = Double.valueOf(classes.get(i).get(j));
				denominator =  Double.valueOf(classes.get(i).get(j+1));
				
				gradeRef =  (numerator / denominator) * 100;

				if (gradeRef >= 97) {
					gradeTotal += 4.0;
				}
				else if (gradeRef >= 93 && gradeRef < 97) {
					gradeTotal += 4.0;
				}
				else if (gradeRef >= 90 && gradeRef < 93) {
					gradeTotal += 3.7;
				}
				else if (gradeRef >= 87 && gradeRef < 90) {
					gradeTotal += 3.3;
				}
				else if (gradeRef >= 83 && gradeRef < 87) {
					gradeTotal += 3.0;
				}
				else if (gradeRef >= 80 && gradeRef < 83) {
					gradeTotal += 2.7;
				}
				else if (gradeRef >= 77 && gradeRef < 80) {
					gradeTotal += 2.3;
				}
				else if (gradeRef >= 73 && gradeRef < 77) {
					gradeTotal += 2.0;
				}
				else if (gradeRef >= 70 && gradeRef < 73) {
					gradeTotal += 1.7;
				}
				else if (gradeRef >= 67 && gradeRef < 70) {
					gradeTotal += 1.3;
				}
				else if (gradeRef >= 65 && gradeRef < 67) {
					gradeTotal += 1.0;
				}
				else {
					gradeTotal += 0.0;
				}
				count++;
			}
		}
		return gradeTotal / count;
	}

	public static double getGrade(ArrayList <String> classList) {
		double denominator = 0;
		double numerator = 0;

			for (int i = 1; i < classList.size(); i = i+2) {
			numerator += Double.valueOf(classList.get(i));
			denominator +=  Double.valueOf(classList.get(i+1));
			}
			return (numerator / denominator) * 100;
	}

	public static String getLGrade(ArrayList <String> classList) {
		double denominator = 0;
		double numerator = 0;
		double gradeRef;

		for (int i = 1; i < classList.size(); i = i+2) {
			numerator += Double.valueOf(classList.get(i));
			denominator +=  Double.valueOf(classList.get(i+1));
		}
		gradeRef =  (numerator / denominator) * 100;

		if (gradeRef >= 97) {
			return "A+";
		}
		else if (gradeRef >= 93 && gradeRef < 97) {
			return "A";
		}
		else if (gradeRef >= 90 && gradeRef < 93) {
			return "A-";
		}
		else if (gradeRef >= 87 && gradeRef < 90) {
			return "B+";
		}
		else if (gradeRef >= 83 && gradeRef < 87) {
			return "B";
		}
		else if (gradeRef >= 80 && gradeRef < 83) {
			return "B-";
		}
		else if (gradeRef >= 77 && gradeRef < 80) {
			return "C+";
		}
		else if (gradeRef >= 73 && gradeRef < 77) {
			return "C";
		}
		else if (gradeRef >= 70 && gradeRef < 73) {
			return "C-";
		}
		else if (gradeRef >= 67 && gradeRef < 70) {
			return "D+";
		}
		else if (gradeRef >= 65 && gradeRef < 67) {
			return "D";
		}
		else {
			return "F";
		}

	}
	
	public static boolean isNumber(String s) {
		boolean number = true;

		try {
		double d = Double.parseDouble(s);
		}
		catch (NumberFormatException e) {
			number = false;
		}
		return number;
	}

	public static ArrayList <String> classCreate() {
		ArrayList <String> list = new ArrayList <String>();
		Scanner sc = new Scanner(System.in);
		int count = 0;
		System.out.println("Please enter a class name.");
		String className = sc.nextLine();
		while (className.isEmpty()) {
			System.out.println("Please enter a class name.");
			className = sc.nextLine();
		}
		list.add(className);

		while (count == 0) {
			System.out.println("Please enter assignment score as a fraction. Enter 'done' when you are finished entering scores.");
			String grade = sc.nextLine();

			while (grade.equalsIgnoreCase("done")) {
				System.out.println("Please enter at least one score.");
				grade = sc.nextLine();
			}

			while (!grade.contains("/")) {
				System.out.println("Please enter assignement score in fractional format. Example: 10/10. Or enter 'done' if you are finished adding classes.");
				grade = sc.nextLine();
				if (grade.equalsIgnoreCase("done")){
					System.out.println("Please enter at least one score.");
				}
			}

			while (!grade.equalsIgnoreCase("done")) {
			
				Scanner scan = new Scanner(grade);
				scan.useDelimiter("/");
		
				String numer = scan.next().trim();
				String denom = scan.next().trim();

				while (isNumber(numer) == false || isNumber(denom) == false) {
					System.out.println("Invalid score. Please enter your score as a fraction using only numbers.");
					grade = sc.nextLine();
					Scanner scanner = new Scanner(grade);
					scanner.useDelimiter("/");
					numer = scanner.next().trim();
					denom = scanner.next().trim();
				}

				while (denom.equalsIgnoreCase("0")) {
					System.out.println("Please enter a vaild denominator.");
					denom = sc.nextLine();
				}
				list.add(numer);
				list.add(denom);
				count++;

				System.out.println("Please enter assignment score as a fraction. Enter 'done' when you are finished entering scores.");
				grade = sc.nextLine();

				if (grade.equalsIgnoreCase("done")){
					break;
				}

				while (!grade.contains("/")) {
					System.out.println("Please enter assignement score in fractional format. Example: 10/10. Or enter 'done' if you are finished adding classes.");
					grade = sc.nextLine();
					if (grade.equalsIgnoreCase("done")) {
						break;
					}
				}
			}
		}
		return list;
		
	}

	public static void main(String[] args) {
		
		ArrayList <ArrayList <String>> classes = new ArrayList <ArrayList <String>>();
		Scanner scnr = new Scanner(System.in);
		int classNum = 0;

		System.out.println("How many classes would you like to enter?");
		boolean done = false;

		while (!done) {
			try {
				classNum = scnr.nextInt();
				done = true;
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter the number of classes as a single integer.");
				scnr.nextLine();
			}
		}
	
		while (classNum <= 0) {
			done = false;
			System.out.println("Please enter a vaild number of classes");
			while (!done) {
				try {
				classNum = scnr.nextInt();
				done = true;
				}
				catch (InputMismatchException e) {
				System.out.println("Please enter the number of classes as a single integer.");
				scnr.nextLine();
				}
			}
		}

		for (int i = 0; i < classNum; i++) {
			classes.add(classCreate());
		}

		scnr.nextLine();
		boolean finished = false;
		boolean complete = false;
		System.out.println("Enter 'grade' for a class grade, or 'gpa' for your gpa.");
		while (!finished) {
		String userInput = scnr.nextLine().trim();

		if (userInput.equalsIgnoreCase("grade")) {
			System.out.println("Which class would you like?");
			String userClass = scnr.nextLine().trim();
			while (!complete) {
				for (int i = 0; i < classes.size(); i++) {
					if (classes.get(i).get(0).equalsIgnoreCase(userClass)) {
						System.out.printf("Your %s grade is %.2f%% (%s)\n", classes.get(i).get(0), getGrade(classes.get(i)), getLGrade(classes.get(i)));
						complete = true;
						finished = true;
						break;
					}
				}
				if (complete) {
				break;
				}
				System.out.println("Please enter a valid class.");
				userClass = scnr.nextLine().trim();
			}
		}

		else if (userInput.equalsIgnoreCase("gpa")) {
			Double userGPA = getGPA(classes);
			String[] splitter = userGPA.toString().split("\\.");

			if (splitter[1].length() > 2) {
				System.out.printf("Your GPA is %.2f\n", userGPA);
			}
			else {
				System.out.println("Your GPA is " + userGPA);
			}
			finished = true;
		}
		
		else {
			System.out.println("Please either enter 'grade' or 'gpa'. ");
		}
		}
	}
}