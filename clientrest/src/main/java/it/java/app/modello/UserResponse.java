package it.java.app.modello;

public class UserResponse {
	private Data data;
	private Supporto supporto;
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Supporto getSupporto() {
		return supporto;
	}
	public void setSupport(Supporto supporto) {
		this.supporto = supporto;
	}
	@Override
	public String toString() {
		return "UserResponse [data=" + data + "]";
	}
	
}
