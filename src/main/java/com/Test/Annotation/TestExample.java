package com.Test.Annotation;

@TestAuthor(authorName = "Paras Agarwal")
public class TestExample {

	@CustomTest
	void TestA() {
		if (true) {
			throw new RuntimeException("This test failed");
		}
	}

	@CustomTest(enabled = false)
	@SuppressWarnings("unused")
	void TestB() {
		if (false) {
			throw new RuntimeException("This test ignored");
		}
	}

	@CustomTest
	void TestC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}
}
