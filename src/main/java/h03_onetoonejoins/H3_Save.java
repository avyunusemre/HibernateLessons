package h03_onetoonejoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {

	public static void main(String[] args) {
		
		H2_Gunluk g1 = new H2_Gunluk(11,"Ahmet'in Gunlugu");
		H2_Gunluk g2 = new H2_Gunluk(12,"Ayse'nin Gunlugu");
		H2_Gunluk g3 = new H2_Gunluk(13,"Can'in Gunlugu");
		
		H1_Ogrenci ogr1 = new H1_Ogrenci(101,"Ahmet Niyazi",88,g1);
		H1_Ogrenci ogr2 = new H1_Ogrenci(102,"Ayse Yilmaz",66,g2);
		H1_Ogrenci ogr3 = new H1_Ogrenci(103,"Can Kosmaz",48,g3);
		
		g1.setOgrenci(ogr1);
		g2.setOgrenci(ogr2);
		g3.setOgrenci(ogr3);
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Gunluk.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	 
		session.save(g1);
		session.save(g2);
		session.save(g3);
		
		session.save(ogr1);
		session.save(ogr2);
		session.save(ogr3);
		
		tx.commit();
		
		sf.close();
		
		session.close();
		
	}
}
