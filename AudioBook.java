package task_10;

import static java.lang.System.*;

public class AudioBook extends Book {
	double length;

	public AudioBook (String name, int year, double length) {
		super (name, year);
		this.setLength(length);
	}
	public void displayInfo() {
		out.printf("Book name: %s\n", this.getName());
		out.printf("Year of publish: %d\n", this.getYear());
		out.printf("Length (hours): %.1f\n", this.getLength());
		out.println();
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
}
