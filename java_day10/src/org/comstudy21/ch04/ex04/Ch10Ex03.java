package org.comstudy21.ch04.ex04;

class spec{
	private String name;
	private String company;
	
	public spec(){
		this("no-name","no-company");
	}
	//generate constructor using fields
	public spec(String name, String company){
		this.name=name;
		this.company=company;
	}
	
	//setter getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	//toString
	@Override
	public String toString() {
		return "spec [name=" + name + ", company=" + company + "]";
	}
	
}

class Speaker{
	private int volume =5;
	
	public void showVolume(){
		System.out.println("스피커 볼륨: "+volume);
	}
	public void soundUp(){
		System.out.println("스피커 볼륨을 올립니다!");
		volume++;
		showVolume();
	}
	public void soundDown(){
		System.out.println("스피커 볼륨을 내립니다!");
		volume--;
		showVolume();
	}
}


class TV extends spec{
	private String name =super.getName();
	private String company = super.getCompany();
	private Speaker speaker;
	//private int volume =5;
	private int channel =10;
	
	public TV(){
		this("테리비","대한전선");
	}
	
	

	public TV(String name,String company){
		super(name,company);
		speaker = new Speaker();
	}
	public void turnOn(){
		System.out.println(company+" "+name+" TV 켜기");
	}
	public void volumUp(){
		speaker.soundUp();
	}
	public void volumDown(){
		speaker.soundDown();
	}
	public void channelUp(){
		System.out.println("현재 볼륨 레벨은 "+(++channel)+"입니다.");
	}
	public void channelDown(){
		System.out.println("현재 볼륨 레벨은 "+(--channel)+"입니다.");
	}
	public void turnOff(){
		System.out.println(company+" "+name+" TV 끄기");
	}
	public void showInfo(){
		System.out.println(this);
		//System.out.println(super.toString());
	}
	
	
}

public class Ch10Ex03 {

	public static void main(String[] args) {
		
		TV tv = new TV("올레드","LG");
		tv.turnOn();//LG 올레드 TV 켜기
		tv.volumUp();//현재 볼륨 레벨은 6입니다.
		tv.volumDown();//현재 볼륨 레벨은 5입니다.
		tv.channelUp();//11번 방송 보기
		tv.channelDown();//10번 방송 보기
		tv.turnOff();//LG 올레드 TV 끄기
		tv.showInfo();
	}

}
