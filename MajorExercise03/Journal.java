import java.util.ArrayList;
import java.util.List;

public class Journal extends Publication {

	private static final long serialVersionUID = 1L;

	private List<Author> editors = new ArrayList<>();

	public Journal() {
		super();
	}
	
	public Journal(String title, int year, Author author) {
		super(title, year, author);
	}

	public Journal(String title, int year, Author author, int pages) {
		super(title, year, author, pages);
	}

	public List<Author> getEditors() {
		return editors;
	}

}
