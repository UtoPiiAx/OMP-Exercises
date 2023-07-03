import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private String name;
	private String location;
	private List<BookShelf> shelves = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<BookShelf> getShelves() {
		return shelves;
	}
	
}
