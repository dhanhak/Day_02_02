package dto;

public class DTO {
	private int id;
	private String writer;
	private String message;

	public DTO() {
		super();
	}

	public DTO(int id, String writer, String message) {
		super();
		this.id = id;
		this.writer = writer;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "id=" + id +"\t"+ ", writer=" + writer +"\t"+ ", message=" + message + "<br>";
	}







}
