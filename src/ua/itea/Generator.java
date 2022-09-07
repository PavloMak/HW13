package ua.itea;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Generator implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (int) (Math.random() * 100 + 1);
	}

}
