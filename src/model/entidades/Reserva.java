package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String atualizaDatas(Date checkIn,Date checkOut) {
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na Reserva: A reserva só pode ser atualizada para datas futuras.";
		}
		if(!checkOut.after(checkIn)) {
			return "Erro na Reserva: A data de Check-Out não pode ser anterior a data de Check-In.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto - " + numeroQuarto);
		sb.append(" | Check-In - " + sdf.format(checkIn));
		sb.append(" | Check-Out - " + sdf.format(checkOut));
		sb.append(" | " + duracao() + " dias.");
		return sb.toString();
	}
}
