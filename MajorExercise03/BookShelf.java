import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookShelf implements Shelf<Publication> {
	
	private Set<String> topics = new HashSet<>();
	private List<Publication> items = new ArrayList<>();
	
	public Set<String> getTopics() {
		return topics;
	}
	public List<Publication> getItems() {
		return items;
	}

}
