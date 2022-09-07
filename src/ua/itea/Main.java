package ua.itea;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<Integer> colection = new ArrayList<Integer>();

		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer> f1;
		Future<Integer> f2;
		Future<Integer> f3;

		while (colection.size() < 10) {
			f1 = es.submit(new Generator());
			f2 = es.submit(new Generator());
			f3 = es.submit(new Generator());

			Integer res1 = f1.get();
			if (res1 % 2 == 0) {
				colection.add(res1);
			}
			
			Integer res2 = f2.get();
			if (res2 % 2 == 0) {
				colection.add(res2);
			}
			
			Integer res3 = f3.get();
			if (res3 % 2 == 0) {
				colection.add(res3);
			}
		}
		
		System.out.println(colection);

	}

}
