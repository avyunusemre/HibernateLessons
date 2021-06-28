package h05_crudProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personeller")
public class Personel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String ad;
	private String soyad;
	private double maas;
	
	public Personel() {
		
	}
	
	public Personel(String ad, String soyad, double maas) {
		this.ad = ad;
		this.soyad = soyad;
		this.maas = maas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}

	@Override
	public String toString() {
		return "Personel [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", maas=" + maas + "]";
	}
	
	
	
}
