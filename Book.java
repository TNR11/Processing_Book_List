package task_10;

public class Book {
	String name;
	int year;
	public Book (String name, int year) {
		this.setName(name);
		this.setYear(year);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
