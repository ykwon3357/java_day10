package org.comstudy21.mpjava;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ch03Ex {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Random rand = new Random();
		String[] comsel = {"가위","바위","보"}; 
		String user="",com="";
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true) {
		System.out.print("가위 바위 보! >> ");
		user= sc.nextLine();
		if(user.equals("그만")) break;
		com=comsel[rand.nextInt(3)];
		
		if(user.equals(com))
			System.out.println("사용자="+user+", 컴퓨터="+com+" 비겼습니다.");
		else {
			switch(user) {
			case "가위":
				switch(com) {
				case "바위": System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 졌습니다.");break;
				case "보":	System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 이겼습니다.");break;
				}break;
			case "바위":
				switch(com) {
				case "보": System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 졌습니다.");break;
				case "가위":	System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 이겼습니다.");break;
				}break;
			case "보":
				switch(com) {
				case "가위": System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 졌습니다.");break;
				case "바위":	System.out.println("사용자="+user+", 컴퓨터="+com+" 사용자가 이겼습니다.");break;
				}break;
			}
		}
		}
		System.out.println("게임을 종료합니다...");
	}
	public static void Ex15(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("곱하고자 하는 두 수 입력 >> ");
        try {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.print(n+"x"+m+"="+n*m);
        scanner.close();
        }catch (Exception e) {
        	System.out.println("실수는 입력하면 안됩니다.");
        	main(null);
        }
	}
	public static void Ex14(String[] args) {
		String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score[]  = {95, 88, 76, 62, 55};
		String subject;
		while(true) {
		System.out.print("과목 이름 >> ");
		subject = sc.nextLine();
		if(subject.equals("그만")) break;
		int i;
		for(i=0;i<course.length;i++) {
			if(course[i].equals(subject)) {
				System.out.printf("%s의 점수는 %d\n",course[i],score[i]);break;
			}
		}
		if(i==course.length)
			System.out.println("없는 과목입니다.");
		};
		System.out.println("종료");
	}
	public static void Ex13(String[] args) {
		for(int i=1;i<100;i++) {
			if((i%10)!=0&&(i/10)%3==0&&(i%10)%3==0) {
				System.out.println(i+"박수 "+"짝짝");
			}else if((i%10)!=0&&(i/10)!=0&&((i/10)%3==0||(i%10)%3==0)) {
				System.out.println(i+"박수 "+"짝");
			}
		}
	}
	public static void Lotto(String[] args) {
		Random rand = new Random();
		int[] Lotto = new int[6];
		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = rand.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(Lotto[i]==Lotto[j]) {
					Lotto[i] = rand.nextInt(45)+1;
					j=-1;
				}
			}
		}
		Arrays.sort(Lotto);
		System.out.println(Arrays.toString(Lotto));
		

	}

	public static void Ex04(String[] args) {
		System.out.print((char) ('b' - 1));
		System.out.print("소문자 알파벳을 하나 입력하시오>>");
		String word = sc.nextLine();
		char c = word.charAt(0);
		for (int i = 0; i <= c - 'a'; i++) {
			for (int j = 'a'; j <= c - i; j++) {
				System.out.print((char) j);
			}
			System.out.println();
		}

	}

}
