package servlet;

public class Listbean {
	private int id;
	private String author;
	private String xinxi;
	private String jianjie;
	public int getId(){
		return id;
	}

	public String getAuthor(){
		return author;
	}
	public String getXinxi(){
		return xinxi;
	}
	public String getJianjie(){
		return jianjie;
	}
	public void setId(int id){
		this.id=id;
	}

	public void setAuthor(String author){
		this.author=author;
	}
	public void setJianjie(String jianjie){
		this.jianjie=jianjie;
	}
	public void setXinxi(String xinxi){
		this.xinxi=xinxi;
	}
}