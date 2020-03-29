package org.comstudy21.homework;

import java.util.Scanner;

class Menu{
	static Scanner sc= new Scanner(System.in);
	private int no;
	public Menu(int no) {
		
		System.out.println("1.입력  2.출력  3.검색   4.수정  5.삭제  6.종료");
		System.out.print("선택: ");
		try {
			no = Integer.parseInt(sc.next());
			this.no=no;
		} catch (NumberFormatException e) {
			sc.nextLine();
			System.out.print("잘못 입력, ");
			this.no=-1;
		}
		
	}
	public int getNo() {
		return no;
	}

}

class Run extends Menu{
	
	public Run() {
		this(0);
		
	}
	
	public Run(int no) {
		super(no);
		switch (getNo()) {
		case 1:
			Input.input();
			break;
		case 2:
			Output.output();
			break;
		case 3:
			System.out.println("검색기능...");
			Search.search();
			break;
		case 4:
			Modify.modify();
			break;
		case 5:
			Delete.delete();
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
class Input extends PhoneBook_v2{}
class Output extends Input{}
class Search extends Output{}
class Modify extends Search{}
class Delete extends Modify{}

public class PhoneBook_v2 {
	public static final int MAX = 100;
	private static People[] pArr = new People[MAX];
	private static int top = 0; // 삭제가 일어나면 감소 된다.
	private static int sequence = 0; /// 객체가 생성될 때 감소 없이 계속 증가. idx에 사용
	public static final Scanner sc = new Scanner(System.in);
	private static int i;

	public PhoneBook_v2() {
		//System.out.println("디폴트 생성자 호출!");	
		while (true) {
			new Run();
		}
	}
	// pArr에 People 객체를 추가한다.
	public static void input() {
		//sc.nextLine();
		System.out.println("입력기능...");
		// 더 이상 입력 할수 없다면 바로 끝내기
		if (top >= pArr.length) {
			System.out.println("더 이상 입력 불가능합니다!");
			return;
		}

		// 1. 객체 생성
		People p = new People();
		// 2. 객체에 데이터 넣기
		p.setIdx(sequence++);
		System.out.print("성명입력: ");
		p.setName(sc.next());
		System.out.print("전화번호: ");
		p.setPhone(sc.next());

		// 3. 객체를 배열의 top번지에 저장
		pArr[top++] = p;

		System.out.println("입력 완료");
	}

	public static void output() {
		System.out.println("출력기능...");
		// pArr의 요소를 top까지 반복해서 출력한다.
		for (People p : pArr) {
			if (p == null)
				break;
			System.out.println(p);
		}
		System.out.println("출력 완료했습니다.");
	}
	
	public static void search() {
		System.out.print("성명 입력: ");
		sc.nextLine();
		String name = sc.next();
		//배열 top 번지까지 돌려서 입력받은 이름과 같은 이름이 있을시 출력하고 끝낸다.
		for (i = 0; i < top; i++) {
			if (name.equals(pArr[i].getName())) {
				System.out.println(pArr[i].toString());
				break;
			}
		}
		//위에 걸린게 없다면 i는 top이 되있음
		if (i == top) {
			System.out.println("검색 결과 없습니다.");
		}
	}
	//수정
	public static void modify() {
		System.out.println("수정기능...수정할 대상 검색");
		search();
		//검색결과가 없다면 해당 메소드 종료
		if (i == top)
			return;
		//입력받은 내용으로 저장시킨다
		System.out.print("성명입력: ");
		pArr[i].setName(sc.next());
		System.out.print("전화번호: ");
		pArr[i].setPhone(sc.next());
		System.out.println("수정 완료했습니다.");

	}

	public static void delete() {
		System.out.println("삭제기능...삭제할 대상 검색");
		search();
		if (i == top)
			return;
		System.out.print("삭제하시겠습니까? (y/n): ");
		String sel = sc.next();
		//y,n 유효성체크
		while (!sel.equals("y") && !sel.equals("n")) {
			System.out.print("잘못 입력, 삭제하시겠습니까? (y/n): ");
			sel = sc.next();
		}
		//삭제할 번지를 그 뒤 번지로 덮어쓴다 -> top번지까지 반복
		if (sel.equals("y")) {
			for (int j = i + 1; j < top; j++) {
				pArr[j - 1] = pArr[j];
			}
			pArr[--top] = null;//마지막 번지는 초기화 해준다.
			System.out.println("삭제 완료했습니다.");
		} else
			System.out.println("삭제 하지않습니다.");
	}

	public static void main(String[] args) {
		new Delete();
	}
}
