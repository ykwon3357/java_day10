package org.comstudy21.mpjava;

import java.util.Scanner;

class TV {
	private String company;
	private int year;
	private int size;

	public TV() {
		this("", 0, 0);
	}

	public TV(String company, int year, int size) {
		this.company = company;
		this.year = year;
		this.size = size;
	}

	public void show() {
		System.out.printf("%s에서 만든 %d년형 %d인치 TV", company, year, size);
	}
}

class Grade {
	private int math, sci, eng;

	public Grade() {
		this(0, 0, 0);
	}

	public Grade(int math, int sci, int eng) {
		this.math = math;
		this.sci = sci;
		this.eng = eng;
	}

	public int average() {
		return (math + sci + eng) / 3;
	}
}

class Song {
	private String title;
	private String artist;
	private int year;
	private String country;

	public Song() {
		this("", "", 0, "");
	}

	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}

	public void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s", year, country, artist, title);
	}
}

class Rectangle {
	private int x, y, width, height;

	public Rectangle() {
		this(0, 0, 0, 0);
	}

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int square() {
		return width * height;
	}

	public void show() {
		System.out.printf("(%d,%d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
	}

	public boolean contains(Rectangle r) {
		if ((x < r.x && r.x + r.width < x + width) && (y < r.y && r.y + r.height < y + height))
			return true;
		else
			return false;
	}
}

class Circle {
	private double x, y;
	private int radius;

	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void show() {
		System.out.printf("(%.1f,%.1f)%d\n", x, y, radius);
	}

	public double area() {
		return radius * radius * Math.PI;
	}
}

class Day {
	private String work; // 하루의 할 일을 나타내는 문자열

	public void set(String work) {
		this.work = work;
	}

	public String get() {
		return work;
	}

	public void show() {
		if (work == null)
			System.out.println("없습니다.");
		else
			System.out.println(work + "입니다.");
	}
}

class MonthSchedule {
	Scanner sc = new Scanner(System.in);
	private Day[] day;
	private int end;

	public MonthSchedule() {
		this(0);
	};

	public MonthSchedule(int end) {
		this.end = end;
		this.day = new Day[end];

		for (int i = 0; i < day.length; i++) {
			day[i] = new Day();
		}
	}

	public void input(int num) {
		System.out.print("할일(빈칸없이입력)?");
		day[--num].set(sc.nextLine());
	}

	public void search(int num) {
		System.out.print(num + "일의 할 일은 ");
		day[--num].show();
	}

	public void run() {
		int menu = 0, day = 0;
		System.out.println("이번달 스케줄 관리 프로그램.");

		do {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3)>>");
			menu = sc.nextInt();
			if (menu == 1) {
				System.out.printf("날짜(1-%d)?", end);
				day = sc.nextInt();
				sc.nextLine();
				input(day);
			}
			if (menu == 2) {
				System.out.printf("날짜(1-%d)?", end);
				day = sc.nextInt();
				sc.nextLine();
				search(day);

			}
		} while (menu != 3);
		System.out.println("프로그램을 종료합니다.");
	}
}

class Phone {
	static Scanner sc = new Scanner(System.in);
	private String name;
	private String tel;
	private Phone[] p;
	private int num;
	private boolean check = false;

	public Phone() {
		this("", "");

	}

	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	private void search() {
		System.out.print("검색할 이름 >>");
		name = sc.nextLine();
		for (int i = 0; i < p.length; i++) {
			if (name.equals(p[i].name)) {
				System.out.printf("%s의 번호는 %s입니다.\n", p[i].name, p[i].tel);
				check = true;
			}
		}
		if (name.equals("그만")) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		if (check == false) {
			System.out.println(name + "이 없습니다.");
		}
	}

	private void input() {
		for (int i = 0; i < p.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			name = sc.next();
			tel = sc.nextLine();
			p[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다...");
	}

	public void run() {
		System.out.print("인원수>>");
		num = sc.nextInt();
		sc.nextLine();
		p = new Phone[num];
		input();
		while (true) {
			search();
		}

	}

}

class ArrayUtil {
	public static int[] concat(int[] a, int[] b) {
		int[] newArr = new int[a.length + b.length];
		for (int i = 0; i < newArr.length; i++) {
			if (i >= a.length) {
				newArr[i] = b[i - a.length];
			} else {
				newArr[i] = a[i];
			}
		}
		return newArr;
	}

	public static void print(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
	}
}

class Dictionary {
	static Scanner sc = new Scanner(System.in);
	private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
	private static String[] eng = { "love", "baby", "money", "future", "hope" };
	private String word;
	private static boolean check = true;

	public static String kor2Eng(String word) {
		for (int i = 0; i < kor.length; i++) {
			if (kor[i].equals(word)) {
				check = false;
				return word + "은 " + eng[i];
			}
		}
		return word + "는 저의 사전에 없습니다.";

	}

	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		while (true) {
			System.out.print("한글 단어?");
			word = sc.nextLine();
			if (word.equals("그만"))
				break;
			System.out.println(kor2Eng(word));
		}
		System.out.println("종료");

	}
}

class Add {
	private int a, b;

	public void SetValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int calculate() {
		return a + b;
	}
}

class Sub {
	private int a, b;

	public void SetValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int calculate() {
		return a - b;
	}
}

class Mul {
	private int a, b;

	public void SetValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int calculate() {
		return a * b;
	}
}

class Div {
	private int a, b;

	public void SetValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int calculate() {
		return a / b;
	}
}

class Concert {
	static Scanner sc = new Scanner(System.in);

	private Concert[] c = new Concert[3];// c[0]=S석,c[1]=A석,c[2]=B석
	private String userName;
	private int selectNum, row, col;
	private String[][] seat = new String[3][10];

	public void delete() {
		showCol();
		System.out.print("\n이름>>");
		sc.nextLine();
		userName = sc.nextLine();
		int j = 0;
		for (; j < seat[row - 1].length; j++) {
			if (seat[row - 1][j].equals(userName)) {
				seat[row - 1][j] = "---";
				break;
			}
		}
		if (j == 10) {
			System.out.println("해당 이름 없습니다.");
		}

	}

	public void show() {
		for (int i = 0; i < seat.length; i++) {
			if (i == 0)
				System.out.print("S>>");
			else
				System.out.print((i == 1) ? "A>>" : "B>>");
			for (int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("<<조회를 완료하였습니다>>");
	}

	public void showCol() {
		System.out.print("좌석구분 S(1),A(2),B(3)>> ");
		row = sc.nextInt();
		if (row == 1) {
			System.out.print("S>>");
			for (int i = 0; i < seat[row - 1].length; i++)
				System.out.print(seat[row - 1][i] + " ");
		} else if (row == 2) {
			System.out.print("A>>");
			for (int i = 0; i < seat[row - 1].length; i++)
				System.out.print(seat[row - 1][i] + " ");
		} else if (row == 3) {
			System.out.print("B>>");
			for (int i = 0; i < seat[row - 1].length; i++)
				System.out.print(seat[row - 1][i] + " ");
		} else
			System.out.println("해당 좌석 없습니다.");

	}

	public void reservation() {
		showCol();
		System.out.print("\n이름>>");
		sc.nextLine();
		userName = sc.nextLine();
		System.out.print("번호>>");
		col = sc.nextInt();
		seat[row - 1][col - 1] = userName;

	}

	public void menu() {

	}

	public void run() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "---";
			}
		}
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while (true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:
				reservation();
				break;
			case 2:
				show();
				break;
			case 3:
				delete();
				break;
			case 4:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("해당 메뉴 없습니다.");
			}
		}

	}

}

class Seat {
	private String[] seat;

	public Seat() {
		seat = new String[10];
		for(int i=0;i<seat.length;i++)
			seat[i]="---";
	}

	public void show() { // 좌석 상태 출력
		for(int i=0;i<seat.length;i++)
			System.out.print(seat[i]+" ");
	}

	public void set(String name, int num) { // 예매된 좌석 정보 처리
		seat[num-1]=name;
	}

	public boolean reSet(String name) { // 좌석 취소 정보 확인 후, 처리
		for(int i=0;i<seat.length;i++) {
			if(seat[i].equals(name))
				seat[i]="---";return true;
		}
		return false;
	}

}

class Reservation {
	static Scanner sc = new Scanner(System.in);
	private Seat s[]; // 세개의 등급 당 좌석 생성
	private String seatGrade[] = { "S", "A", "B" }; // 좌석 등급별 이름

	public Reservation() {
		s= new Seat[3];
		for(int i=0;i<s.length;i++) {
			s[i] = new Seat();
		}
	}

	public void input() {
		System.out.print("좌석구분 S(1), A(2), B(3)>> ");
		int num = sc.nextInt();
		System.out.print(seatGrade[num-1]+">>");
		s[num-1].show();
		
		System.out.print("\n이름>>");
		String name = sc.next();
		System.out.print("\n번호>>");
		int col = sc.nextInt();
		s[num-1].set(name, col);
	}

	public void check() {
		for(int i=0;i<s.length;i++) {
			System.out.print(seatGrade[i]+">>");
			s[i].show();
			System.out.printf("%s",(i==2)?"\n<<<조회를 완료하였습니다.>>>\n":"\n");
		}
		
	}

	public void delete() {
		System.out.print("좌석구분 S(1), A(2), B(3)>> ");
		int num = sc.nextInt();
		System.out.print(seatGrade[num-1]+">>");
		s[num-1].show();
		System.out.print("\n이름>>");
		String name = sc.next();
		boolean result = s[num-1].reSet(name);
		if(result) {
			System.out.println("\n<<<취소를 완료하였습니다.>>>");
		}else
			System.out.println("\n해당 대상 없습니다.");
	}


	public void run() {
		System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			input();
			break;
		case 2:
			check();
			break;
		case 3:
			delete();
			break;
		case 4:
			System.out.println("프로그램 종료");
			System.exit(0);
		default:
			System.out.println("해당 메뉴 없습니다.");
		}
	}
}

	
	
public class Ch04Ex {
	static Scanner sc = new Scanner(System.in);


	public static void Ex12_2(String[] args) {//오류
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		Reservation r = new Reservation();
		while(true) {
		r.run();
		}
	}

	public static void main(String[] args) {
		Concert c = new Concert();
		c.run();
	}

	public static void Ex11(String[] args) {
		System.out.print("두 정수와 연산자를 입력하시오>>");
		int a = sc.nextInt();
		int b = sc.nextInt();
		String op = sc.next();
		int result = 0;
		switch (op) {
		case "+":
			Add add = new Add();
			add.SetValue(a, b);
			result = add.calculate();
			break;
		case "-":
			Sub sub = new Sub();
			sub.SetValue(a, b);
			result = sub.calculate();
			break;
		case "*":
			Mul mul = new Mul();
			mul.SetValue(a, b);
			result = mul.calculate();
			break;
		case "/":
			Div div = new Div();
			div.SetValue(a, b);
			result = div.calculate();
			break;
		default:
			System.out.println("연산자 잘못 입력");
		}
		System.out.println(result);

	}

	public static void Ex10(String[] args) {
		Dictionary d = new Dictionary();
		d.run();

	}

	public static void Ex09(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}

	public static void Ex08(String[] args) {
		Phone p = new Phone();
		p.run();

	}

	public static void Ex07(String[] args) {
		MonthSchedule march = new MonthSchedule(31);
		march.run();
	}

	public static void Ex06(String[] args) {
		Circle[] c = new Circle[3];
		double x, y;
		int radius, max = 0;
		for (int i = 0; i < c.length; i++) {
			System.out.print("x,y,radius>>");
			x = sc.nextDouble();
			y = sc.nextDouble();
			radius = sc.nextInt();
			c[i] = new Circle(x, y, radius);

			if (c[i].area() > c[max].area()) {
				max = i;
			}
		}
		System.out.print("가장 면적이 큰 원은 ");
		c[max].show();

		sc.close();

	}

	public static void Ex05(String[] args) {
		Circle[] c = new Circle[3];
		double x, y;
		int radius;
		for (int i = 0; i < c.length; i++) {
			System.out.print("x,y,radius>>");
			x = sc.nextDouble();
			y = sc.nextDouble();
			radius = sc.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		for (int i = 0; i < c.length; i++)
			c[i].show();
		sc.close();
	}

	public static void Ex04(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);

		r.show();
		System.out.println("S의 면적은 " + s.square());
		if (t.contains(r))
			System.out.println("t는 r을 포함합니다.");
		if (t.contains(s))
			System.out.println("t는 s를 포함합니다.");
	}

	public static void Ex03(String[] args) {
		Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
		s.show();
	}

	public static void Ex02(String[] args) {

		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average());
		sc.close();
	}

	public static void Ex01(String[] args) {
		TV myTV = new TV("LG", 2017, 32);
		myTV.show();
	}

}
