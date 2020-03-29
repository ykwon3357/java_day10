package org.comstudy21.ch04.re;
class 스펙{
	private String name;
	private String company;
	private int amount;
	
	public 스펙() {
		this("","",0);
	}
	public 스펙(String name, String company, int amount) {
		this.name=name;
		this.company=company;
		this.amount=amount;
	}
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "스펙 [name=" + name + ", company=" + company + ", amount=" + amount + "]";
	}
	
	
}
class setak extends 스펙{
	public setak(){}
	public setak(String name, String company, int amount){
		super(name,company,amount);
	}
	public void 세탁() {
		String name = super.getName();
		int amount = super.getAmount();
		System.out.println(name+"세탁기가"+amount+"kg을 세탁합니다.");
	}
	public void 탈수() {
		String name = super.getName();
		int amount = super.getAmount();
		System.out.println(name+"세탁기가"+amount+"kg을 탈수합니다.");
	}
	public void showInfo() {
		System.out.println(this);
	}
}

public class ReCh10Ex02 {

	public static void main(String[] args) {
		setak washer = new setak("트롬","LG",100);
		washer.세탁();
		washer.탈수();
		washer.showInfo();
	}

}
