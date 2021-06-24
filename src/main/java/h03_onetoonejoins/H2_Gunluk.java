package h03_onetoonejoins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gunlukler")
public class H2_Gunluk {
	
	@Id
	private int id;
	private String yazilar;
	
	@OneToOne
	@JoinColumn(name="ogr_id")
	private H1_Ogrenci ogrenci;
	
	public H1_Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(H1_Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
	
	public H2_Gunluk() {

	}

	public H2_Gunluk(int id, String isim) {
		this.id = id;
		this.yazilar = isim;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return yazilar;
	}

	public void setIsim(String isim) {
		this.yazilar = isim;
	}

	@Override
	public String toString() {
		return "Gunluk id=" + id + ", isim=" + yazilar    ;
	}




}
