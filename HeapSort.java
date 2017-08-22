package sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000000];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10000000);
		}
		long start = System.currentTimeMillis();
		heapSort(arr);			//time 40+s
		//Arrays.sort(arr);		//time 10+s
		System.out.println(System.currentTimeMillis() - start);
		
		
//		for(int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
//		
		
//		
//		for(int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
		
	}
	
	public static void heapSort(int[] arr) {
		build(arr, arr.length);
		int head = 0, end = arr.length;
		for(; end > 0; end--) {
			swap(arr, head, end - 1);
			adjust(arr, head, end - 1);
		}
	}
	
	public static void build(int[] arr, int end) {			//build a big top heap
		for(int i = end/2 - 1; i >= 0; i--) {
			int left = 2*i + 1, right = 2*i + 2;
			if(right < end && arr[left] < arr[right]) {
				if(arr[i] < arr[right]) {
					swap(arr, i, right);
					adjust(arr, right, end);
				}
			}
			if(arr[i] < arr[left]) {
				swap(arr, i, left);
				adjust(arr, left, end);
			}
		}
	}
	public static void adjust(int[] arr, int idx, int end) { //adjust a heap
		int left = 2*idx + 1, right = 2*idx + 2; 
		if(left < end) {
			if(right < end) {
				if(arr[idx] < arr[right] && arr[left] < arr[right]) {
					swap(arr, idx, right);
					adjust(arr, right, end);
					return;
				}
			}
			if(arr[idx] < arr[left]) {
				swap(arr, idx, left);
				adjust(arr, left, end);
			}
		}
	}
	
	public static void swap(int[] arr, int a, int b) {	//swap arr[a] and arr[b]
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
