package mentoring.application.model;

import java.util.List;

public class Account {
	
	private List<Person> persons;
	
	private List<Purse> purses;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Purse> getPurses() {
		return purses;
	}
	
	public void setPurses(List<Purse> purses) {
		this.purses = purses;
	}
	
}
