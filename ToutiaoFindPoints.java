package sortAlgorithms;

import java.util.*;

public class ToutiaoFindPoints {
	
	public static void main(String[] args) {
		List<Point> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 3; i++) {
			list.add(new Point(rand.nextDouble()*10, rand.nextDouble()*10));
		}
		Set<Point> ans = new HashSet<>();
		find(list,ans);
		for(Point p : list) {
			System.out.println(p);
		}
		System.out.println("+++++++++++++++++++++++");
		for(Point p : ans) {
			System.out.println(p);
		}
		
	}

	private static void find(List<Point> list, Set<Point> ans) {
		if(list == null || list.size() == 0) {
			return;
		}
		Point top = list.get(0), right = list.get(0);
		for(Point p : list) {
			if(p.getY() > top.getY()) {
				top = p;
			}
			if(p.getX() > right.getX()) {
				right = p;
			}
		}
		List<Point> remain = new ArrayList<>();
		for(Point p : list) {
			if(p.getX() > top.getX() && p != right) {
				remain.add(p);
			}
			if(p.getY() > right.getY() && p != top) {
				remain.add(p);
			}
		}
		ans.add(top);
		ans.add(right);
		find(remain, ans);
	}

	
}
