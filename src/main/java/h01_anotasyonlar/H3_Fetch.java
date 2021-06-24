package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Fetch {
		
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Belirtilen tablodan istenilen id'li kisiyi getir. İstenilen kayıt yoksa null döndürür.
		H1_Ogrenci ogr= session.get(H1_Ogrenci.class, 103);
		H1_Ogrenci ogr2= session.get(H1_Ogrenci.class, 104);
		
		
		System.out.println(ogr);//toString() metodunun ilgili class'ta tanımlanması yeterli
		System.out.println(ogr2);
		tx.commit();
		
		session.close();
		sf.close();
		
		
		
	}
}
