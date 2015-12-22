package com.Sample2.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ExecutorFramework {
	@SuppressWarnings("unchecked")
	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		final FutureTask favAccountTask = new FutureTask(new Callable() {
			@Override
			public String call() throws Exception {
				return executeRequest("ABC");
			}
		});

		// set up task to retrieve either user or customer accounts
		final FutureTask allAccountTask = new FutureTask(new Callable() {

			@Override
			public String call() throws Exception {
				return executeRequest("DEF");
			}

		});

		// execute both task simultaneously
		final ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(favAccountTask);
		es.execute(allAccountTask);

		// get the response from the initiated tasks -- in built wait
		final String favAccountResponse = (String) favAccountTask.get();
		final String allAccountResponse = (String) allAccountTask.get();

		System.out.println(favAccountResponse);
		System.out.println(allAccountResponse);
		// close the executor
		es.shutdown();

	}

	private static String executeRequest(final String string) {
		return string;
	}
}
