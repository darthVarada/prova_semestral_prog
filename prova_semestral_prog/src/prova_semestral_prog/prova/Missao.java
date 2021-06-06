package prova_semestral_prog.prova;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Missao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private LocalDate dataTerra;

	private int nrDiasMarte;

	private double longSolar;

	private int mesMarte;

	private double minTemp;

	private double maxTemp;

	private double pressaoAtm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataTerra() {
		return dataTerra;
	}

	public void setDataTerra(LocalDate dataTerra) {
		this.dataTerra = dataTerra;
	}

	public int getNrDiasMarte() {
		return nrDiasMarte;
	}

	public void setNrDiasMarte(int nrDiasMarte) {
		this.nrDiasMarte = nrDiasMarte;
	}

	public double getLongSolar() {
		return longSolar;
	}

	public void setLongSolar(double longSolar) {
		this.longSolar = longSolar;
	}

	public int getMesMarte() {
		return mesMarte;
	}

	public void setMesMarte(int mesMarte) {
		this.mesMarte = mesMarte;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public double getPressaoAtm() {
		return pressaoAtm;
	}

	public void setPressaoAtm(double pressaoAtm) {
		this.pressaoAtm = pressaoAtm;
	}

}
