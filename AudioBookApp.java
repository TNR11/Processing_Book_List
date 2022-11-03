package task_10;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.System.*;

public class AudioBookApp {
	private List<AudioBook> booklist;//list to store books from txt file.
	public List<AudioBook> getBookList() {
		return booklist;
	}
	public AudioBookApp(String filename) throws IOException {
		booklist = new LinkedList<>();
		readData(filename);
	}
	public void readData(String filename) throws IOException {
		booklist = new LinkedList<>();
		Path path = Paths.get(filename);
		List<String> lines = Files.readAllLines(path);//reading all lines from txt file into string
		for (String line: lines) {//For-each loop to iterate through entire list of data
			String [] items = line.split(",");//splitting individual variable data and storing into array
			String name = items[0];
			int year = Integer.parseInt(items[1]);
			double length = Double.parseDouble(items[2]);
			AudioBook a = new AudioBook(name,year,length);//creating instance of audiobook based on data from txt file.
			booklist.add(a);//adding instance of audiobook to list
		}
	}
	public AudioBook getShortestBook() {
		AudioBook min = booklist.get(0);
		for (AudioBook e : booklist) {
			if (e.getLength() < min.getLength()) {//if current audiobook length is shorter than update min.
				min = e;
			}
		}
		return min;
	}
	public int countBooks() {
		int count = 0;
		for (AudioBook e : booklist) {
			if (e.getYear() >= 2010 && e.getYear() <= 2020) {
				count ++;
			}
		}
		return count;
	}
	public void randomBookList() {
		List<AudioBook> b1 = new LinkedList<>();
		List<AudioBook> b2 = new LinkedList<>();
		List<AudioBook> b3 = new LinkedList<>();
		int ran = 0;
		for (AudioBook e : booklist) {
			ran = ThreadLocalRandom.current().nextInt(1,4);
			if (ran == 1) {
				b1.add(e);
			} else if (ran ==2) {
				b2.add(e);
			} else {
				b3.add(e);
			}
		}
		out.printf("%s books in list #1\n", b1.size());
		for (AudioBook e : b1) {
			out.printf("%s %d %.1f\n", e.getName(), e.getYear(), e.getLength());
		}
		out.printf("\n%s books in list #2\n", b2.size());
		for (AudioBook e : b2) {
			out.printf("%s %d %.1f\n", e.getName(), e.getYear(), e.getLength());
		}
		out.printf("\n%s books in list #3\n", b3.size());
		for (AudioBook e : b3) {
			out.printf("%s %d %.1f\n", e.getName(), e.getYear(), e.getLength());
		}
	}
}

