import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private List<String> middleNames = new ArrayList<>();
	private String lastName;

	public Author() {
		super();
	}
	
	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getMiddleNames() {
		return middleNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleNames == null) ? 0 : middleNames.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleNames == null) {
			if (other.middleNames != null)
				return false;
		} else if (!middleNames.equals(other.middleNames))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
}
