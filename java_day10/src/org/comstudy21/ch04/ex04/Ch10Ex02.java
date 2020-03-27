package org.comstudy21.ch04.ex04;

class 스팩{
	private int 용량;
	private String 이름;
	private String 제조사;
	//디폴트 생성자
	public 스팩(){
		this("no-name","no-company",0);
	}
	//생성자 오버로딩
	public 스팩(String 이름, String 제조사, int 용량){
		this.이름=이름;
		this.제조사=제조사;
		this.용량=용량;
	}
	//setters, getters
	public int get용량() {
		return 용량;
	}
	public void set용량(int 용량) {
		this.용량 = 용량;
	}
	public String get이름() {
		return 이름;
	}
	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	public String get제조사() {
		return 제조사;
	}
	public void set제조사(String 제조사) {
		this.제조사 = 제조사;
	}
	//toString
	@Override
	public String toString() {
		return "스팩 [용량=" + 용량 + ", 이름=" + 이름 + ", 제조사=" + 제조사 + "]";
	}
	
}

class 세탁기 extends 스팩 {
	
	public 세탁기(){}
	public 세탁기(String 이름, String 제조사, int 용량){
		//부모클래스 생성자를 명시적으로 호출
		super(이름,제조사,용량);
	}
	
	public void 세탁(){
		String 이름 = super.get이름();
		int 용량 = super.get용량();
		
		System.out.println(이름+"세탁기가 "+용량+"kg의 빨래 한다~");
	}
	public void 탈수(){
		String 이름 = super.get이름();
		int 용량 = super.get용량();
		
		System.out.println(이름+"세탁기가 "+용량+"kg의 빨래를 탈수 한다~");
	}
	public void showInfo(){
		//세탁기에 toString()이 없다면 부모의 toString() 호출
		System.out.println(this);
	}
	
}

public class Ch10Ex02 {

	public static void main(String[] args) {
		
		세탁기 washer = new 세탁기("트롬","LG",100);
		washer.세탁();
		washer.탈수();
		washer.showInfo();

	}

}
