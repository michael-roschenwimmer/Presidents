package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;


public class PresidentsDaoImpl implements PresidentsDAO{
	private ServletContext context;
	private List<President> presidents = new ArrayList<>();
	private int tracker = 0;
	
	public PresidentsDaoImpl(ServletContext context) {
		this.context = context;
	}
	
	public int getNext() {
//		tracker++;
		System.out.println("in getNext");
		return tracker +1;
	}
	public int getPrevious() {
//		tracker--;
		System.out.println("in getPrevious");
		return tracker + -1;
	}
	public int getTracker() {
		return tracker;
	}
	public void setTracker(int t) {
		tracker = t;
	}
	
	
	@Override
    public President getTermNumber(Integer termNumber) {
        President president = null;
        if (termNumber == null) {
            return president;
        }
        for (President p : presidents) {
            if (termNumber.equals(p.getTermNumber())) {
                president = p;
                break;
            }

        }
        return president;

    }
	
	@Override
	public List<President> loadPresidentsFromFile(ServletContext context) {
		InputStream is = context.getResourceAsStream("WEB-INF/presidents.txt");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String record;
			while ((record = reader.readLine()) != null) {
				
				String[] column = record.split("\\|");
				int termNumber = Integer.parseInt(column[0]);
				String firstName = column[1];
				String middleName = column[2];
				String lastName = column[3];
				String name = firstName.concat(middleName).concat(lastName);
				String year = column[4];
				String[] years = year.split("-");
				int startYear = Integer.parseInt(years[0]);
				int endYear = Integer.parseInt(years[1]);
				String party = column[5];
				String funFact = column[6];
				President pres = new President(termNumber, startYear, endYear, name, party, funFact);
				presidents.add(pres);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return presidents;
	}
	
	 @Override
	    public List<President> getFilteredList(String filtered){
	        List<President> president = new ArrayList<>();
	        if (filtered.equals(null)) {
	            return president;
	        }
	        for (President p : presidents) {
	            if (filtered.equals(p.getName())){
	                president.add(p);
	                break;
	            }
	        for (President p1 : presidents) {
	            if (filtered.equals(p1.getFunFact())){
	                president.add(p1);
	                break;
	            }
	        for (President p2 : presidents) {
	            if (filtered.equals(p2.getParty())){
	                president.add(p2);
	                break;
	            }
	        }
	            
	        }
	        
	    }
			return president;
	}
	@Override
	public String getPic(President p) {
        
        return "PresidentPics/" + p.getTermNumber() + ".jpg";
    }

}
