public class Book extends Publication {

	private static final long serialVersionUID = 1L;
	
	private String isbn;

	public Book() {
		super();
	}
	
	public Book(String title, int year, Author author) {
		super(title, year, author);
	}

	public Book(String title, int year, Author author, int pages) {
		super(title, year, author, pages);
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
