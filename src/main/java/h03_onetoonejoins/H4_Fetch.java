package h03_onetoonejoins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Gunluk.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		H1_Ogrenci ogrenci = new H1_Ogrenci();
		H2_Gunluk gunluk = new H2_Gunluk();

		// id'si 101 olan ogrencinin bilgilerini okuyalım
//		ogrenci = session.get(H1_Ogrenci.class, 101);
//		System.out.println(ogrenci);

		// id'si 1002 olan gunlugun bilgilerini okuyalım
//		gunluk = session.get(H2_Gunluk.class, 12);
//		System.out.println(gunluk);

		// Ogrenciler ve Gunlukler tablolarindaki ortak olan kayıtların,
		// Ogrenci adi, gunluk yazisi(yazilar) ve ogrenci notu (ogrNot) bilgilerini
		// sorgulayiniz.

		// SQL Komutlari
//		String sql1 = "SELECT o.ogr_ad, g.yazilar, o.ogr_not" + " FROM ogrenciler o" + " INNER JOIN gunlukler g"
//				+ " ON o.ogr_id = g.ogr_id";
//
//		List<Object[]> sonuclarListesi1 = session.createSQLQuery(sql1).getResultList();
//
//		for (Object[] w : sonuclarListesi1) {
//			System.out.println(Arrays.toString(w));
//		}

		// HQL Komutlari(Sadece class ve değişken isimleri kullanılabilir.)
		String hql1 = "SELECT o.ogrAd, g.yazilar, o.ogrNot "
				+ "FROM H1_Ogrenci o INNER JOIN H2_Gunluk g "
				+ "ON o.ogrId = g.ogrenci";
		
		List<Object[]> sonucListesi2 = session.createQuery(hql1).getResultList();
		
		for(Object [] w: sonucListesi2) {
			System.out.println(Arrays.toString(w));
		}

		tx.commit();

		sf.close();
		session.close();
	}
}
