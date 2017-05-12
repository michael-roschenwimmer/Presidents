package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class PresidentsDaoImpl implements PresidentsDAO{
	private List<President> presidents = new ArrayList<>();
	@Override
	public void getTermNumber() {
		
	}
	@Override
	public List<President> loadPresidentsFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("WEB-INF/presidents.txt"))) {
			String record = reader.readLine();
			while ((record = reader.readLine()) != null) {
				String[] col = record.split("\\|");

				int term = Integer.parseInt(col[0]);
				String fName = col[1];
				String mName = col[2];
				String lName = col[3];
				LocalDate termBegin = LocalDate.parse(col[4], formatter);
				LocalDate termEnd;
				termEnd = null;
				try {
					termEnd = LocalDate.parse(col[5], formatter);
				} catch (DateTimeParseException e) {
					System.out.println();
				}
				int won = Integer.parseInt(col[6]);
				String whyLeft = col[7];
				String party = col[8];
				//
				President pres = new President(term, fName, mName, lName, termBegin, termEnd, won, whyLeft, party);
				presidents.add(pres);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
	@Override
	public List<President> getFilteredList(String List){
		return null;
	}

}
