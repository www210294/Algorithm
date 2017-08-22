package sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100000000);
		}
		long start = System.currentTimeMillis();
		// Arrays.sort(arr); //time 10+s
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
		quickSort(arr, 0, arr.length - 1); // time 15s
//		Arrays.sort(arr);					// time 11s
		//HeapSort.heapSort(arr);
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int p1 = start, p2 = start, comp = arr[start];
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < comp) {
				arr[p1] = arr[i];
				p1++;
				arr[i] = arr[p2 + 1];
				arr[p2 + 1] =  comp;
				p2++;
			}else if (arr[i] == comp) {				//attention :  else can not be deleted!!!!!
				swap(arr, p2 + 1, i);
				p2++;
			}
		}
		quickSort(arr, start, p1 - 1);
		quickSort(arr, p2 + 1, end);
	}

	public static void swap(int[] arr, int a, int b) { // swap arr[a] and arr[b]
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
