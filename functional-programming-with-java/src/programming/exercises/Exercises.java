package programming.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercises {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200));
		cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800));
		cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700));
		cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400));
		cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300));
		
		//System.out.printf("Num de cursos con duracion mayor a 5 horas: %d \n", CursosDuracionMayorCinco(cursos));
		//System.out.printf("Num de cursos con duracion menor a 2 horas: %d \n", CursosDuracionMenorDos(cursos));
		//CursosMasDeCincuentaVideos(cursos);
		//TresCursosMasDuracion(cursos);
		//System.out.printf("Duracion total de los cursos: %f \n", DuracionTotalCursos(cursos));
		//CursosDuracionMayorPromedio(cursos);
		//CursosConMenosQuinientosAlumnos(cursos);
		//CursoMayorDuracion(cursos);
		ListaTodosTitulos(cursos);
	}
	
	public static float CursosDuracionMayorCinco (List<Curso> cursos) {
				
		   return	cursos.stream()
				   .filter(curso -> curso.getDuracion()>=5)
				   .count();
	}
	
	public static float CursosDuracionMenorDos (List<Curso> cursos) {
		
		   return	cursos.stream()
				   .filter(curso -> curso.getDuracion()<2)
				   .count();
	}
	
	public static void CursosMasDeCincuentaVideos (List<Curso> cursos) {
		
		   	cursos.stream()
			.filter(curso -> curso.getVideos()>=50)
			.forEach(System.out::println);
	}
	
	public static void TresCursosMasDuracion (List<Curso> cursos) {
		
	   	cursos.stream()
	   	//.sorted(Comparator.comparing(Curso::getDuracion))
	   	.sorted((c1, c2) -> Float.compare(c2.getDuracion(), c1.getDuracion()))
	   	.limit(3)
	   	.map(curso -> curso.getTitulo())
		.forEach(System.out::println);
	   	
	}
	
	public static float DuracionTotalCursos (List<Curso> cursos) {
		
	   return	cursos.stream()
			    .map(curso -> curso.getDuracion())
			    .reduce(0f, Float::sum);
	   	
	}
	
	public static void CursosDuracionMayorPromedio (List<Curso> cursos) {
		
		 double promedioDuracion = cursos.stream()
				 				.mapToDouble(Curso::getDuracion)
				 				.average()
				 				.orElse(0);
		   	
		 cursos.stream()
		 .filter(curso -> curso.getDuracion() > promedioDuracion)
		 .forEach(System.out::println);
		 
	}
	
	public static void CursosConMenosQuinientosAlumnos (List<Curso> cursos) {
		
		cursos.stream()
		.filter(curso -> curso.getAlumnos() < 500)
		.forEach(System.out::println);
		 
	}
	
	public static void CursoMayorDuracion (List<Curso> cursos) {
		
		cursos.stream()
		.sorted((c1,c2) -> Float.compare(c2.getDuracion(), c1.getDuracion()))
		.limit(1)
		.forEach(System.out::println);
		 
	}
	
	public static void ListaTodosTitulos (List<Curso> cursos) {
		
		List<String> listaCursos = cursos.stream()
									.map(curso -> curso.getTitulo())
									.collect(Collectors.toList());
		 
		listaCursos.forEach(System.out::println);
	}
	
	
	
}

//Crear una lista de Strings con todos los titulos de los cursos.