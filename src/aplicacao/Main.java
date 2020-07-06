package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int n = sc.nextInt();
		System.out.print("Data de Check-In: (DD/MM/AAAA) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Check-Out: (DD/MM/AAAA) ");
		Date checkOut = sdf.parse(sc.next());
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na Reserva: A data de Check-Out não pode ser anterior a data de Check-In.");
		}
		else{
			Reserva reserva = new Reserva(n,checkIn,checkOut);
			System.out.println("Reserva: " + reserva.toString());
			System.out.println();
			System.out.println("Entre com os dados da nova reserva");
			System.out.print("Data de Check-In: (DD/MM/AAAA) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: (DD/MM/AAAA) ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.atualizaDatas(checkIn, checkOut);
			if(erro != null) {
				System.out.println(erro);	
			}
			else {
				System.out.println("Reserva: " + reserva.toString());
			}
				
			
		}
		sc.close();
	}
	
	

}
