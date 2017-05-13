package data;

import java.util.List;

import javax.servlet.ServletContext;

public interface PresidentsDAO {
	President getTermNumber(Integer termNumber);
	List<President> loadPresidentsFromFile(ServletContext context);
	List<President> getFilteredList(String filtered);
	String getPic(President p);
}
