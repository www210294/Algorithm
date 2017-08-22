package sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class mergeSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000000000);
		}
		long start = System.currentTimeMillis();
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
		mergeSort(arr); // time 2s
//		Arrays.sort(arr);					// time 12s
		//HeapSort.heapSort(arr);
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n");
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	public static void sort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		sort(arr, start, mid);
		sort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int p1 = start, p2 = mid + 1;
		for(int i =0; i < temp.length; i++) {
			if(p1 > mid) {				//part 1 used up
				temp[i] = arr[p2++];
				continue;
			}
			if(p2 > end) {				//part 2 used up
				temp[i] = arr[p1++];
				continue;
			}
			if(arr[p1] <= arr[p2]) {
				temp[i] = arr[p1];
				p1++;
			} else {
				temp[i] = arr[p2];
				p2++;
			}
		}
		for(int i = 0; i < end - start + 1; i++) {		//copy the sorted temp into unsorted array
			arr[start + i] = temp[i];
		}
	}

	
}
