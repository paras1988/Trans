package com.Sample2.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Test extends Thread {

	public static final String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static final TimeZone UTC;
	private static final DateFormat originalformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	/**
	 * 0001-01-01T00:00:00.000Z
	 */
	public static final Date BEGINNING_OF_TIME;

	/**
	 * 292278994-08-17T07:12:55.807Z
	 */
	public static final Date END_OF_TIME;

	static {
		UTC = TimeZone.getTimeZone("UTC");
		TimeZone.setDefault(UTC);
		final Calendar c = new GregorianCalendar(UTC);
		c.set(1, 0, 1, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		BEGINNING_OF_TIME = c.getTime();
		c.setTime(new Date(Long.MAX_VALUE));
		END_OF_TIME = c.getTime();
	}

	private static final String timezoneCode = "UTC";
	private static final TimeZone timezone = TimeZone.getTimeZone(timezoneCode);

	public static void main(final String[] args) {

	}

	static int findGCD(int n, final int m) {
		if (n % m == 0) {
			return m;
		}
		n = n % m;
		return findGCD(m, n);
		/*
		 * 1) Calculate the medians m1 and m2 of the input arrays ar1[]
		 * and ar2[] respectively.
		 * 2) If m1 and m2 both are equal then we are done.
		 * return m1 (or m2)
		 * 3) If m1 is greater than m2, then median is present in one
		 * of the below two subarrays.
		 * a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
		 * b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
		 * 4) If m2 is greater than m1, then median is present in one
		 * of the below two subarrays.
		 * a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
		 * b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
		 * 5) Repeat the above process until size of both the subarrays
		 * becomes 2.
		 * 6) If size of the two arrays is 2 then use below formula to get
		 * the median.
		 * Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
		 */

		/*
		 * 1) Get the middle element of ar1[] using array indexes left and right.
		 * Let index of the middle element be i.
		 * 2) Calculate the corresponding index j of ar2[]
		 * j = n – i – 1
		 * 3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
		 * are the middle elements.
		 * return average of ar2[j] and ar1[i]
		 * 4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then
		 * do binary search in left half (i.e., arr[left ... i-1])
		 * 5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
		 * do binary search in right half (i.e., arr[i+1....right])
		 * 6) If you reach at any corner of ar1[] then do binary search in ar2[]
		 */

	}

	// taking middle of one and checking from other.. stops when one is j<ele<j+1

	int getMedianRec(final int ar1[], final int ar2[], final int left, final int right, final int n) {
		int i, j;
		/* We have reached at the end (left or right) of ar1[] */
		if (left > right) {
			return getMedianRec(ar2, ar1, 0, n - 1, n);
		}
		i = (left + right) / 2;
		j = n - i - 1;
		/* Index of ar2[] */
		/* Recursion terminates here. */
		if (ar1[i] > ar2[j] && (j == n - 1 || ar1[i] <= ar2[j + 1])) {
			/*
			 * ar1[i] is decided as median 2, now select the median 1
			 * (element just before ar1[i] in merged array) to get the
			 * average of both
			 */
			if (i == 0 || ar2[j] > ar1[i - 1]) {
				return (ar1[i] + ar2[j]) / 2;
			} else {
				return (ar1[i] + ar1[i - 1]) / 2;
			}
		}
		/* Search in left half of ar1[] */
		else if (ar1[i] > ar2[j] && j != n - 1 && ar1[i] > ar2[j + 1]) {
			return getMedianRec(ar1, ar2, left, i - 1, n);
			/* Search in right half of ar1[] */
		} else {
			/* ar1[i] is smaller than both ar2[j] and ar2[j+1] */
			return getMedianRec(ar1, ar2, i + 1, right, n);
		}
	}

	// Taking 2 medians and comparing them... stops when end arrays are of size 2

	int getMedian(final int ar1[], final int ar2[], final int n) {
		int m1;
		/* For median of ar1 */
		int m2; /* For median of ar2 */
		/* return -1 for invalid input */
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return (ar1[0] + ar2[0]) / 2;
		}
		if (n == 2) {
			// return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
		}
		m1 = median(ar1, n);
		/* get the median of the first array */
		m2 = median(ar2, n);
		/* get the median of the second array */
		/* If medians are equal then return either m1 or m2 */
		if (m1 == m2) {
			return m1;
		}
		/* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
		if (m1 < m2) {
			if (n % 2 == 0) {
				// return getMedian(ar1 + n / 2 - 1, ar2, n - n / 2 + 1);
			} else {
				// return getMedian(ar1 + n / 2, ar2, n - n / 2);
			}
		}
		/* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
		else {
			if (n % 2 == 0) {
				// return getMedian(ar2 + n / 2 - 1, ar1, n - n / 2 + 1);
			} else {
				// return getMedian(ar2 + n / 2, ar1, n - n / 2);
			}
		}
		return 0;
	}

	/* Function to get median of a sorted array */
	int median(final int arr[], final int n) {
		if (n % 2 == 0) {
			return (arr[n / 2] + arr[n / 2 - 1]) / 2;
		} else {
			return arr[n / 2];
		}
	}

	void myMedianRec(final int arr1[], final int arr2[], final int l, final int r, final int n) {

		if (l > r) {
			myMedianRec(arr2, arr1, 0, n - 1, n);
		}
		final int i = (l + r) / 2;
		final int j = n - i - 1;

		if (arr1[i] > arr2[j] && (j == n - 1 || arr1[i] < arr2[j + 1])) {
			if (arr2[j] > arr1[i - 1]) {
				System.out.println((arr1[i] + arr2[j]) / 2);
			} else {
				System.out.println((arr1[i] + arr1[i - 1]) / 2);
			}
		}

		if (arr1[i] > arr2[j] && j != n - 1 && arr1[i] > arr2[j + 1]) {
			myMedianRec(arr1, arr2, l, i - 1, n);
		} else {
			myMedianRec(arr1, arr2, i + 1, r, n);
		}

	}

}