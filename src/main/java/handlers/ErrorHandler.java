package handlers;

import java.util.Objects;

public class ErrorHandler {
	
	public void logError(String message, Exception exception) {
		
		System.err.println("\n"+message);
		System.err.println("Detalhes: " + exception.getMessage());
		
		if (Objects.nonNull(exception.getCause())) {

			System.err.println("Causa original: " + exception.getCause().getMessage());
		}
	}
}