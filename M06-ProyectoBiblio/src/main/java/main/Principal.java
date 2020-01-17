package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Autor;

public class Principal {

	static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		boolean salir = false;
		while (salir  == false) {
			System.out.println("------------------------------------------------");
			System.out.println("Menu");
			System.out.println("======================");
			System.out.println("1.-Insert y mostrar");
			System.out.println("2.-Modificar");
			System.out.println("3.-Eliminar por id");
			System.out.println("4.-Fin");
			System.out.println("=====================");

			int pos = lector.nextInt();
			switch (pos) {
			case 1:
				insertarDato();
				break;

			case 2:
				modificarDato();
				break;

			case 3:
				eliminarDato();
				break;

			case 4:
				System.out.println("Fin");
				salir=true;
				break;

			default:
				System.out.println("Escribe bien el numero");
				break;
			}
		}

	}

	public static void insertarDato() {
		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();

		Autor newAutor = new Autor();
		newAutor.setNomAutor("Federico Garcia Lorca");
		
		session.save(newAutor);
		tx.commit();

		System.out.println("Autor insertado");
		System.out.println(newAutor.getIdAutor());
		System.out.println(newAutor.getNomAutor());


		session.close();
	}

	public static void modificarDato() {
		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		
		System.out.println("Que id quieres modificar?");
		int id_autor = lector.nextInt();
		
		Autor autorCambio = (Autor) session.load(Autor.class, id_autor);
		autorCambio.setNomAutor("Alberto Pachon");
		
		session.update(autorCambio);
		tx.commit();
		
		System.out.println("Dato modificado");
		
		session.close();
	}
	
	public static void eliminarDato() {
		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		
		System.out.println("Que id quieres eliminar?");
		int id_autor = lector.nextInt();
		
		Autor autorCambio = (Autor) session.load(Autor.class, id_autor);
		
		session.delete(autorCambio);
		tx.commit();
		
		System.out.println("Dato eliminado");
		
		session.close();
	}
}
