package sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * find the first Ns Small numbers in a array
 * @author Administrator
 *
 */
public class NsSmall {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}
		long start = System.currentTimeMillis();
		int[] ans = findNsSmall(arr, 10);			//time 40+s
		//Arrays.sort(arr);		//time 10+s
		System.out.println(System.currentTimeMillis() - start);
		
		
		for(int i : arr) {					//original array
			System.out.print(i + " ");
		}
		System.out.println("\n");
//		
		
//		
		for(int i : ans) {					//the first n smallest number
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		heapSort(arr); 
		
		for(int i : arr) {				//the sorted array
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		
	}
	public static  int[] findNsSmall(int[] arr, int n) {
		if(arr.length < n) {
			return null;
		}
		int[] ans = Arrays.copyOf(arr, n);
		build(ans, n);
		for(int i = n; i < arr.length; i++) {
			if(ans[0] > arr[i]) {
				ans[0] = arr[i];
				adjust(ans, 0, n);
			}
		}
		return ans;
	}
	public static void heapSort(int[] arr) {
		build(arr, arr.length);
		int head = 0, end = arr.length;
		for(; end > 0; end--) {
			swap(arr, head, end - 1);
			adjust(arr, head, end - 1);
		}
	}
	
	public static void build(int[] arr, int end) {			//build a Small top heap
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
