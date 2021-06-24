package h02_embeddable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ogrenciler")
public class H1_Ogrenci {
	
	@Id
	@Column(name="ogr_id")
	private int ogrId;
	
	@Column(name="ogr_ad")
	private String ogrAd;
	
	@Column(name="ogr_not")
	private double ogrNot;
	
//	@Transient
//	private String adres;
	
	@Column(name="dersler")
	private H2_Dersler dersler;
	
	public H2_Dersler getDersler() {
		return dersler;
	}

	public void setDersler(H2_Dersler dersler) {
		this.dersler = dersler;
	}
	
	public H1_Ogrenci() {
		
	}
	
	public H1_Ogrenci(int ogrId, String ogrAd, double ogrNot, H2_Dersler dersler) {
		this.ogrId = ogrId;
		this.ogrAd = ogrAd;
		this.ogrNot = ogrNot;
		this.dersler = dersler;
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

	@Override
	public String toString() {
		return "H1_Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", dersler=" + dersler ;
	}
	
	
	
}