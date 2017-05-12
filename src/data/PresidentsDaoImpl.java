package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;


public class PresidentsDaoImpl implements PresidentsDAO{
	private ServletContext context;
	private List<President> presidents = new ArrayList<>();
	
	public PresidentsDaoImpl(ServletContext context) {
		this.context = context;
	}
	
	@Override
	public void getTermNumber() {
		
	}
	@Override
	public List<President> loadPresidentsFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("WEB-INF/presidents.txt"))) {
			String record = reader.readLine();
			while ((record = reader.readLine()) != null) {
				String[] column = record.split("\\|");

				int termNumber = Integer.parseInt(column[0]);
				String firstName = column[1];
				String middleName = column[2];
				String lastName = column[3];
				String name = firstName.concat(middleName).concat(lastName);
				int startYear = Integer.parseInt(column[4]);
				int endYear = Integer.parseInt(column[5]);
				String funFact = column[6];
				President pres = new President(termNumber, startYear, endYear, name, funFact);
				presidents.add(pres);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return presidents;
	}
	@Override
	public List<President> getFilteredList(String List){
		return null;
	}

}
