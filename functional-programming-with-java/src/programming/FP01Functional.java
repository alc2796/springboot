package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = List.of(100,9,13,4,5,2,4,12,15);
		//printAllNumberInListFunctional(numbers);
		//printEvenNumberInListFunctional(numbers);
		//printSquareOfEvenNumberInListFunctional(numbers);
		printCubeOfOddNumberInListFunctional(numbers);
	}
	
	private static void printAllNumberInListFunctional(List<Integer> numbers) {
		
		numbers.stream().forEach(System.out::println); //Method reference
		
		/*
		los pasos que se estan siguiendo aqui son los siguientes:
		numbers.stream() convierte la lista en un flujo (stream) de cada
		numero de forma separada, despues de eso usamos forEach para que para
		cada uno de esos numeros se llame a la funcion print
		*/
		
	}
	
	private static void printEvenNumberInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
		.filter(number -> number%2==0) //Lambda expression
		.forEach(System.out::println); //Method reference

	}
	
	private static void printSquareOfEvenNumberInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
		.filter(number -> number%2==0) //Lambda expression
		.map(number -> number * number) //mapping expression
		.forEach(System.out::println); //Method reference

	}
	
	private static void printCubeOfOddNumberInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
		.filter(number -> number%2!=0) //Lambda expression
		.map(number -> number * number * number) //mapping expression
		.forEach(System.out::println); //Method reference

	}

}
