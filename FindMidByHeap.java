package sortAlgorithms;

import java.util.Random;

public class FindMidByHeap {

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[16];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		long start = System.currentTimeMillis();
		double mid = findMid(arr);
		System.out.println(mid);
		System.out.println(System.currentTimeMillis() - start);
		
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		heapSort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
	}
	public static double findMid(int[] arr) {
		//int len = (int)Math.ceil(arr.length / 2);
		int len = arr.length;
		int[] leftHeap = new int[len], rightHeap = new int[len];
		int p1 = 0, p2 =0, mid = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < mid) {
				leftHeap[p1] =  arr[i];
				bigAddAdjust(leftHeap, p1++);
			} else {
				rightHeap[p2] = arr[i];
				smallAddAdjust(rightHeap, p2++);
			} 
			
			if(Math.abs(p1 - p2) >= 2) {
				if(p1 > p2) {
					rightHeap[p2] = mid;
					smallAddAdjust(rightHeap, p2++);
					mid = leftHeap[0];
					bigRmAdjust(leftHeap, 0, p1--);
				} else {
					leftHeap[p1] = mid;
					bigAddAdjust(leftHeap, p1++);
					mid = rightHeap[0];
					smallRmAdjust(rightHeap, 0, p2--);
				}
			}
		}
		if(p1 == p2) {
			return mid;
		} else {
			int temp = p1 > p2 ? leftHeap[0] : rightHeap[0];
			return (temp * 0.1 + mid)/2;
		}
		
	}
	
	
	
	public static void smallAddAdjust(int[] leftHeap, int p1) {
		if(p1 == 0) {
			return;
		}
		int parent = (p1 - 1) / 2;
		if(leftHeap[p1] < leftHeap[parent]) {
			swap(leftHeap, p1, parent);
			smallAddAdjust(leftHeap, parent);
		}
	}
	public static void bigAddAdjust(int[] leftHeap, int p2) {
		if(p2 == 0) {
			return;
		}
		int parent = (p2 - 1) / 2;
		if(leftHeap[p2] > leftHeap[parent]) {
			swap(leftHeap, p2, parent);
			bigAddAdjust(leftHeap, parent);
		}
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
	public static void bigRmAdjust(int[] arr, int idx, int end) { //adjust a heap
		adjust(arr, idx, end);
	}
	public static void smallRmAdjust(int[] arr, int idx, int end) { //adjust a heap
		int left = 2*idx + 1, right = 2*idx + 2; 
		if(left < end) {
			if(right < end) {
				if(arr[idx] > arr[right] && arr[left] > arr[right]) {
					swap(arr, idx, right);
					smallRmAdjust(arr, right, end);
					return;
				}
			}
			if(arr[idx] > arr[left]) {
				swap(arr, idx, left);
				smallRmAdjust(arr, left, end);
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
