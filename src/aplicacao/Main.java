package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.exceptions.DominioException;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int n = sc.nextInt();
			System.out.print("Data de Check-In: (DD/MM/AAAA) ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (DD/MM/AAAA) ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(n,checkIn,checkOut);
			System.out.println("Reserva: " + reserva.toString());
			
			System.out.println();
			System.out.println("Entre com os dados da nova reserva");
			System.out.print("Data de Check-In: (DD/MM/AAAA) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (DD/MM/AAAA) ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva.toString());
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido.");
		}
		catch(DominioException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado.");
		}
			
		sc.close();
	}
	
	

}
