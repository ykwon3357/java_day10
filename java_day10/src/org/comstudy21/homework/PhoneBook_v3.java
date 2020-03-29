package org.comstudy21.homework;

import java.util.Scanner;

class Menu3 {
	static Scanner sc = new Scanner(System.in);
	private int no;

	public void menu3(int no) {
		System.out.println("1.입력  2.출력  3.검색   4.수정  5.삭제  6.종료");
		System.out.print("선택: ");
		try {
			no = Integer.parseInt(sc.next());
		} catch (NumberFormatException e) {
			sc.nextLine();
			System.out.print("잘못 입력, ");
			new Menu(0);
		}
		this.no = no;
	}

	public int getNo() {
		return no;
	}
}

class Run3 extends Menu3 {
	Delete3 d3 = new Delete3();

	public void run3() {
		menu3(0);
		switch (getNo()) {
		case 1:
			d3.input3();
			break;
		case 2:
			d3.output3();
			break;
		case 3:
			System.out.println("검색기능...");
			d3.search3();
			break;
		case 4:
			d3.modify3();
			break;
		case 5:
			d3.delete3();
			break;
		case 6:
			System.out.println("종료...");
			System.exit(0);
			break;
		default:
			System.out.println("해당 사항 없습니다!");
		}
		System.out.println("----------------------------");
	}
}

class Input3 extends PhoneBook_v3 {

	public void input3() {
		System.out.println("입력기능...");
		// 더 이상 입력 할수 없다면 바로 끝내기
		if (getTop() >= getpArr().length) {
			System.out.println("더 이상 입력 불가능합니다!");
			return;
		}

		// 1. 객체 생성
		People p = new People();
		// 2. 객체에 데이터 넣기
		p.setIdx(getSequence());
		setSequence(getSequence() + 1);
		System.out.print("성명입력: ");
		p.setName(sc.next());
		System.out.print("전화번호: ");
		p.setPhone(sc.next());

		// 3. 객체를 배열의 top번지에 저장
		getpArr()[getTop()] = p;
		setTop(getTop() + 1);
		System.out.println("입력 완료");
	}
}

class Output3 extends Input3 {

	public void output3() {
		System.out.println("출력기능...");
		// pArr의 요소를 top까지 반복해서 출력한다.
		for (People p : getpArr()) {
			if (p == null)
				break;
			System.out.println(p);
		}
		System.out.println("출력 완료했습니다.");
	}
}

class Search3 extends Output3 {
	private int i;

	public int getI() {
		return i;
	}

	public void search3() {
		System.out.print("성명 입력: ");
		sc.nextLine();
		String name = sc.next();
		// 배열 top 번지까지 돌려서 입력받은 이름과 같은 이름이 있을시 출력하고 끝낸다.
		for (i = 0; i < getTop(); i++) {
			if (name.equals(getpArr()[i].getName())) {
				System.out.println(getpArr()[i].toString());
				break;
			}
		}
		// 위에 걸린게 없다면 i는 top이 되있음
		if (i == getTop()) {
			System.out.println("검색 결과 없습니다.");
		}
	}
}

class Modify3 extends Search3 {
	public void modify3() {
		System.out.println("수정기능...수정할 대상 검색");
		search3();
		// 검색결과가 없다면 해당 메소드 종료
		if (getI() == getTop())
			return;
		// 입력받은 내용으로 저장시킨다
		System.out.print("성명입력: ");
		getpArr()[getI()].setName(sc.next());
		System.out.print("전화번호: ");
		getpArr()[getI()].setPhone(sc.next());
		System.out.println("수정 완료했습니다.");
	}
}

class Delete3 extends Modify3 {
	public void delete3() {
		System.out.println("삭제기능...삭제할 대상 검색");
		search3();
		if (getI() == getTop())
			return;
		System.out.print("삭제하시겠습니까? (y/n): ");
		String sel = sc.next();
		// y,n 유효성체크
		while (!sel.equals("y") && !sel.equals("n")) {
			System.out.print("잘못 입력, 삭제하시겠습니까? (y/n): ");
			sel = sc.next();
		}
		// 삭제할 번지를 그 뒤 번지로 덮어쓴다 -> top번지까지 반복
		if (sel.equals("y")) {
			for (int j = getI() + 1; j < getTop(); j++) {
				getpArr()[j - 1] = getpArr()[j];
			}
			setTop(getTop() - 1);
			getpArr()[getTop()] = null;// 마지막 번지는 초기화 해준다.
			System.out.println("삭제 완료했습니다.");
		} else
			System.out.println("삭제 하지않습니다.");
	}
}

public class PhoneBook_v3 {
	public static final int MAX = 100;
	private static People[] pArr = new People[MAX];
	private static int top = 0; // 삭제가 일어나면 감소 된다.
	private static int sequence = 0; /// 객체가 생성될 때 감소 없이 계속 증가. idx에 사용
	public static final Scanner sc = new Scanner(System.in);

	public static People[] getpArr() {
		return pArr;
	}

	public static void setpArr(People[] pArr) {
		PhoneBook_v3.pArr = pArr;
	}

	public static int getTop() {
		return top;
	}

	public static void setTop(int top) {
		PhoneBook_v3.top = top;
	}

	public static int getSequence() {
		return sequence;
	}

	public static void setSequence(int sequence) {
		PhoneBook_v3.sequence = sequence;
	}

	public PhoneBook_v3() {
		// System.out.println("디폴트 생성자 호출!");
	}

	public static void main(String[] args) {
		Run3 r3 = new Run3();
		while (true) {
			r3.run3();
		}
	}
}
