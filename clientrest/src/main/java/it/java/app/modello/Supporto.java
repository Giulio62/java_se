package it.java.app.modello;

public class Supporto {
	private String url;
	private String text;
	public Supporto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Supporto [url=" + url + ", text=" + text + "]";
	}
	
	
	
	

}
