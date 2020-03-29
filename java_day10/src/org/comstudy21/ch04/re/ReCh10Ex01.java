package org.comstudy21.ch04.re;

class washer{
	private int 용량 = 0;
	private String company="";
	private String name="";
	
	public washer() {
		this(0,"no-company","no-name");
	}

	public washer(int i, String company, String name) {
		this.용량=i;
		this.company=company;
		this.name=name;
	}
	
	public void wash() {
		System.out.println("세탁합니다.");
	}
	public void dehydration() {
		System.out.println("탈수합니다.");
	}
	public void showinfo() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "[용량=" + 용량 + ", company=" + company + ", name=" + name + "]";
	}
	
	
}



public class ReCh10Ex01 {

	public static void main(String[] args) {
		
		washer w = new washer(100, "삼성", "최강세탁기");
		
		w.wash();
		w.dehydration();
		w.showinfo();

	}

}
