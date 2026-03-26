package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudAppApplication.class, args);
	}



@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

	return runner -> {
		//createStudent(studentDAO);
		 createMultipleStudent(studentDAO);
		//citim studentii
		// readStudent(studentDAO);
		//queryForStudents(studentDAO);
		//queryForStudentsByLastName(studentDAO);
		//updateStudent(studentDAO);
		//deleteStudent(studentDAO);
		//deleteAllStudents(studentDAO);
	};
	}
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students.");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//gaseste studentul in baza de date dupa id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student newStudent = studentDAO.findById(studentId);

		//modifica prenumele studentului in ion
		System.out.println("Updating student ....");
		newStudent.setFirstName("Vasile");

		//salveaza modif in baza de date
		studentDAO.update(newStudent);

		//afiseaza detaliile studentului actualizat
		System.out.println("Updated student: " + newStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//returneaza lista de studenti
		List<Student> theStudent = studentDAO.findByLastName("popescu");

		//afiseaza lista de studenti
		for(Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//obtain students list
		List<Student> theStudents = studentDAO.findAll();

		//get students list
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}


	private void createStudent(StudentDAO studentDAO) {

		// create a Student object
		System.out.println("Creating a new student object ...");
		Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

		//save the object in BD with DAY
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// GET ID-ul the save student
		System.out.println("Saved student. Generated id: " + newStudent.getId() );
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects ...");
		Student newStudent1 = new Student("Marcu", "Abaduc", "marc@gamil.com");
		Student newStudent2 = new Student("Ioana", "Mandru", "mindrui@yahoo.com");
		Student newStudent3 = new Student("Arsenie", "Dima","arsen@gmail.com");

		System.out.println("Saving students ...");
				studentDAO.save(newStudent1);
				studentDAO.save(newStudent2);
				studentDAO.save(newStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a Student object
		System.out.println("creating new student object ...");
		Student newStudent = new Student("mircea", "popescu", "popescu@hmail.com");

		//save the student in DB
		System.out.println("sabving the student ...");
		studentDAO.save(newStudent);

		// get de student id
		int theId = newStudent.getId();
		System.out.println("saved student. generated id: " + theId );

		//recuperez/ recover studentul dupa id pk
		System.out.println("retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//get the student details
		System.out.println("found the student : " + myStudent);
	}
}
