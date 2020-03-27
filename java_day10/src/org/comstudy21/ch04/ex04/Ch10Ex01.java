package org.comstudy21.ch04.ex04;

import java.util.Arrays;

class Test{
	public void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
	public void printArr(int[][] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public int[] joinArr(int[] arr1, int[] arr2){
		int[] newArr= new int[arr1.length+arr2.length];
		int i=0;
		for(;i<arr1.length;i++){
			newArr[i] = arr1[i];
		}
		for(;i<newArr.length;i++){
			newArr[i] = arr2[i-arr1.length];
		}
		
		return newArr;
	}
	
	public int[][] mkArr(int[] ... arr2){
		//int[][] arr = new int[arr2.length][];
		
		return arr2;
	}
//	public int[][] mkArr(int[] arr, int[] arr2){
//		int[][] newArr = new int[2][];
//		newArr[0] = arr;
//		newArr[1] = arr2;
//		return newArr;
//	}
}

class washer{
	private int amount =0;
	private String company ="";
	private String productName="";
	
	public washer(int amount, String company, String productName){
		this.amount = amount;
		this.company = company;
		this.productName = productName;
	}
	
	public void wash(){
		System.out.println("세탁합니다.");
	}
	public void dehydration(){
		System.out.println("탈수합니다.");
	}
	public void showinfo(){
		System.out.println(amount+"L");
		System.out.println(company);
		System.out.println(productName);
	}
}

public class Ch10Ex01 {

	public static void main(String[] args) {
		int[] arr1={10,20,30,40,50};
		int[] arr2={60,70,80};
		int[] arr6={60,70,80};
		
		Test test = new Test();
		
		int[] arr3=test.joinArr(arr1,arr2);
		test.printArr(arr3);
		System.out.println("\n------------------------");
		
		int[][] arr4 = test.mkArr(arr1,arr2,arr6);
		test.printArr(arr4);
		System.out.println("\n------------------------");
		
		washer w = new washer(100, "삼성", "최강세탁기");
		
		w.wash();
		w.dehydration();
		w.showinfo();

	}

}
