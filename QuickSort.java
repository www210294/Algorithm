package sortAlgorithms;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000000];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10000000);
		}
		long start = System.currentTimeMillis();
		quickSort(arr);			//time 
		//Arrays.sort(arr);		//time 10+s
		System.out.println(System.currentTimeMillis() - start);
	}
	public static void quickSort(int[] arr) {
		
	}
}
