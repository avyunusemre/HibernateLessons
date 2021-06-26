package h04_onetomanyjoins;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ogrenci_tablosu")//, orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY// 
public class H1_Ogrenci {
	
	@Id
	private int ogrId;
	
	private String ogrAd;
	
	private double ogrNot;
	
	@OneToMany(mappedBy="ogrenci")
	private List<H2_Kitap> kitapListesi = new ArrayList<>();

	
	public H1_Ogrenci() {
		
	}
	
	public H1_Ogrenci(int ogrId, String ogrAd, double ogrNot) {
		this.ogrId = ogrId;
		this.ogrAd = ogrAd;
		this.ogrNot = ogrNot;
	}


	public int getOgrId() {
		return ogrId;
	}


	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}


	public String getOgrAd() {
		return ogrAd;
	}


	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}


	public double getOgrNot() {
		return ogrNot;
	}


	public void setOgrNot(double ogrNot) {
		this.ogrNot = ogrNot;
	}


	public List<H2_Kitap> getKitapListesi() {
		return kitapListesi;
	}

	public void setKitapListesi(List<H2_Kitap> kitapListesi) {
		this.kitapListesi = kitapListesi;
	}

	@Override
	public String toString() {
		return "Ogrenci [ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", kitapListesi="
				+ kitapListesi + "]";
	}
	
	

}
