package org.comstudy21.ch04.ex04;

class 할베{
	public void 나팔(){
		System.out.println("할베가 나팔을 분다");
	}
}
//is A 관계가 된다.
class 아베 extends 할베{
	public void 나팔(){
		System.out.println("아베가 나팔을 분다");
	}
}
//is A 관계
class 손자 extends 아베{
	public void 나팔(){
		System.out.println("손자가 나팔을 분다");
	}
}

public class Ch10Ex04 {

	public static void main(String[] args) {
		할베 hal = new 할베();
		hal.나팔();
		
		hal = new 아베();
		hal.나팔();
		
		hal = new 손자();
		hal.나팔(); //손자 나팔
		
		//모든 클래스는 Object클래스를 묵시적으로 상속 받는다.
		Object obj =hal;
		//부모 클래스에 선언되지 않은 자손의 멤버는 호출할 수 없다.
		//자손으로 형변환(캐스팅) 하면 호출 가능
		((할베)obj).나팔();
		
		//손자 son = new 할베();
	}
	public static void test(String[] args) {
		할베 할 = new 할베();
		아베 아 = new 아베();
		손자 손 = new 손자();
		
		System.out.println(손 instanceof 손자);
		System.out.println(손 instanceof 아베);
		System.out.println(손 instanceof 할베);
		System.out.println(할 instanceof 손자);
		System.out.println(할 instanceof 아베);
		System.out.println(할 instanceof 할베);
		
		할.나팔();
		아.나팔();
		손.나팔();
		
	}

}
