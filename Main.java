package task_10;
/**
 * Assignment task 10: Processing Book List
 * Author: Aadil Imran, 2022
 */
import static java.lang.System.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String txtfile = "data/book.txt";//path to txt file.
		try {
			AudioBookApp app = new AudioBookApp(txtfile);
			AudioBook shortest = app.getShortestBook();
			if(shortest != null) {
				out.println("Shortest book:");
				shortest.displayInfo();
			}
			out.printf("Books published btw 2010-2020: %d\n", app.countBooks());
			out.println();
			app.randomBookList();
		}catch(IOException ioe) {
			out.printf("Perhaps missing txt file: %s%s? \n\n", new Main().getClass().getPackage().getName(), txtfile);
		}
	}
}
