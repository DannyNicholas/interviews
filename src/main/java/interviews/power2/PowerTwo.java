package interviews.power2;

public class PowerTwo {

	public static void main(String[] args) {
		PowerTwo powerTwo = new PowerTwo();

		long testValue = 64;
		System.out.println("Test Value: " + testValue);

		boolean loopResult = powerTwo.loop(testValue);
		System.out.println("Loop Result: " + loopResult);

		boolean forLoopResult = powerTwo.forLoop(testValue);
		System.out.println("For Loop Result: " + forLoopResult);

		boolean recursionResult = powerTwo.recursion(testValue, 1);
		System.out.println("Recursion Result: " + recursionResult);

	}

	public boolean loop(long value) {

		long currentValue = 1;
		do {
			// System.out.println(currentValue);
			if (currentValue == value) {
				return true;
			}
			currentValue = currentValue * 2;
		} while (currentValue <= value && currentValue > 0);

		return false;
	}

	public boolean forLoop(long value) {

		for (long i = 1; i <= value; i = i * 2) {
			// System.out.println(i);
			if (i == value) {
				return true;
			}
			if (i < 0) {
				break;
			}
		}
		return false;
	}

	public boolean recursion(long initialValue, long currentValue) {
		if (initialValue == currentValue) {
			return true;
		}
		if (currentValue > initialValue || currentValue < 0) {
			return false;
		}
		return recursion(initialValue, currentValue * 2);
	}
}
