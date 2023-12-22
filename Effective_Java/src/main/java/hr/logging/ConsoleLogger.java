package hr.logging;

public class ConsoleLogger {

	public void writeInfo(String msg) {
		System.out.println("Info: " + msg);
	}

	public void writeError(String msg) {
		System.err.println("Error: " + msg );
	}

}
