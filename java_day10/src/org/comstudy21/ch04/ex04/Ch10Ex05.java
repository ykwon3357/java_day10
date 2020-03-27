package org.comstudy21.ch04.ex04;

import java.util.Scanner;

class Shape {
	protected double res;

	// 오버라이드를 목적으로 선언했다.
	public void area() {
	}

}

class Circle extends Shape {
	private int r;

	public Circle() {
		this(1);
	}

	public Circle(int r) {
		this.r = r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public void area() {
		System.out.println(r * r * Math.PI);
	}
}

class Rectangle extends Shape {
	private int w, h;

	public Rectangle() {
		this(1, 1);
	}

	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public void area() {
		System.out.println(w * h);
	}
}

class Triangle extends Shape {
	int w, h;

	public Triangle() {
		this(1, 1);
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public void area() {
		System.out.println(w * h / 2);
	}
}

public class Ch10Ex05 {
//	static void showShape(Shape shape) {
//		System.out.print("도형의 면적은: ");
//			shape.area();
//		
//	}
	
	static void showShape(Object obj){ //모든 클래스는 object 클래스를 상속받기 때문에 Object obj 로 객체 생성 후 circle 등을 받아옴
		System.out.print("도형의 면적은: ");
		if (obj instanceof Shape) {
			((Shape) obj).area();//obj에는 area()메소드가 없기 때문
		} else {
			System.out.println("obj는 Shape 형이 아닙니다!");
		}
	}

	public static void main(String[] args) {

		Shape[] arr = { new Circle(10), 
				new Rectangle(10, 10),
				new Triangle(10, 10) };

		for (int i = 0; i < arr.length; i++) {
			showShape(arr[i]);
		}
	}

}
