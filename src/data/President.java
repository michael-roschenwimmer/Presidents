package data;

public class President {
	private int termNumber, startYear, endYear;
	private String name, funFact, party;
	
	public President(int termNumber, int startYear, int endYear, String name, String party, String funFact) {
		this.termNumber = termNumber;
		this.startYear = startYear;
		this.endYear = endYear;
		this.name = name;
		this.party = party;
		this.funFact = funFact;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}
	
	public void setParty(String party) {
		this.party = party;
	}
	public String getFunFact() {
		return funFact;
	}

	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		builder.append(termNumber);
		builder.append(", startYear=");
		builder.append(startYear);
		builder.append(", endYear=");
		builder.append(endYear);
		builder.append(", name=");
		builder.append(name);
		builder.append(", funFact=");
		builder.append(funFact);
		builder.append("]");
		return builder.toString();
	}

}
