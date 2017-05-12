package data;

import java.util.List;

public interface PresidentsDAO {
	void getTermNumber();
	List<President> loadPresidentsFromFile();
	List<President> getFilteredList(String List);
}
