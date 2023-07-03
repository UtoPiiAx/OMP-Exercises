import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Publication implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private List<String> topics = new ArrayList<>();
	private String publisher;
	private String location;
	private int year;
	private List<Page> pages = new ArrayList<>();
	private List<Author> authors = new ArrayList<>();
	private List<Publication> references = new ArrayList<>();
	private List<Publication> referencedBy = new ArrayList<>();
	
	public Publication() {
		super();
	}
	
	public Publication(String title, int year, Author author) {
		super();
		setTitle(title);
		setYear(year);
		getAuthors().add(author);
	}
	
	public Publication(String title, int year, Author author, int pages) {
		this(title, year, author);
		for (int i = 1; i <= pages; i++) {
			getPages().add(new Page(i));
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<String> getTopics() {
		return topics;
	}
	public List<Page> getPages() {
		return pages;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public Collection<Publication> getReferences() {
		return Collections.unmodifiableList(references);
	}
	public Collection<Publication> getReferencedBy() {
		return Collections.unmodifiableList(referencedBy);
	}
	public void addReference(Publication to) {
		references.add(to);
		to.referencedBy.add(this);
	}
	
}
