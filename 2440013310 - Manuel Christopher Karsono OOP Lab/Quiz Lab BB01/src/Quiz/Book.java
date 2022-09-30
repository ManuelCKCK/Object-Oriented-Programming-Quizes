package Quiz;

public class Book {

	private String name;
	private int price;
	private String description;
	private String libname;
	private String bookID;
	public Book(String name, int price, String description, String libname, String bookID) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.libname = libname;
		this.bookID = bookID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLibname() {
		return libname;
	}
	public void setLibname(String libname) {
		this.libname = libname;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

}
