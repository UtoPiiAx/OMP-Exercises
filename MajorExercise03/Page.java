import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private int number;
	private String text;
	
	public Page() {
		super();
	}
	
	public Page(int number) {
		super();
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
