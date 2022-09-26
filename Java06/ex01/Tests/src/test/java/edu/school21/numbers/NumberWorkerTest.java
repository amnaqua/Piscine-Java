package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
	NumberWorker numberWorker;

	@BeforeEach
	void numberWorkerInit() {
		numberWorker = new NumberWorker();
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149})
	public void isPrimeForPrimes(int prime) {
		Assertions.assertTrue(numberWorker.isPrime(prime));
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 6, 8, 9, 34, 35, 36, 38, 39, 40, 42, 44, 45, 49, 50, 51, 52, 54, 55, 62, 63})
	public void isPrimeForNotPrimes(int notPrime) {
		Assertions.assertFalse(numberWorker.isPrime(notPrime));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, Integer.MIN_VALUE, -12105 - 1212024})
	public void isPrimeForWrongArgs(int arg) {
		Assertions.assertThrows(IllegalNumberException.class, () -> new NumberWorker().isPrime(arg));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void isSumCorrect(int input, int expected) {
		Assertions.assertEquals(expected, new NumberWorker().digitsSum(input));
	}
}