package h05_crudProject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudMethods {

	private SessionFactory factory;

	public void sessionFactoryOlustur() {

		try {
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personel.class);

			factory = con.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Session grubu olustururken hata olustu : " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public Long personelEkle(String ad, String soyad, double maas) {
		Long personelId = null;
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Personel personel = new Personel(ad, soyad, maas);
			personelId = (Long) session.save(personel);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return personelId;
	}

	// Veri tabanından silme metodu
	public void idIlePersonelSil(Long personelId) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			if (personel == null) {
				System.out.println(personelId + " nolu kişinin kaydı bulunamamıştır.");
			} else {
				session.delete(personel);
				tx.commit();
				System.out.println(personelId + " nolu kişinin kaydı silinmiştir.");
			}
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Veri tabanındaki tüm kayıtları listeleyen metod
	public void tumPersoneliListele() {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Personel";

			List<Personel> personeller = session.createQuery(hql).getResultList();
			System.out.println("****************** TUM PERSONELIN LISTESI ************************");

			personeller.stream().forEach((p) -> System.out.println(p.toString()));
			
			// Alternatif yazdirma
//			personeller.stream().forEach((p) -> {
//		       System.out.print(" ID: " + p.getId()); 
//		       System.out.print(" Ad: " + p.getAd()); 
//			   System.out.print(" Soyad: " + p.getSoyad()); 
//			   System.out.println(" Maas: " + p.getMaas()); 
//		    });
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	//id ile bir kaydin bilgilerini listeyen metot (READ)
	public void idIlePersonelListele(Long personelId) {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			if(personel == null) {
				System.out.println(personelId + " nolu kişi bulunamamıştır.");
			}else {
				tx.commit();
				System.out.println("********************** " + personelId + " nolu personel **********************" );
				System.out.println(personel.toString());
			}
			

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	//id ile bir kaydin maas bilgisini guncelleyen metod(UPDATE)
	public void idIleMaasGuncelleme(Long personelId, double maas) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			if(personel == null) {
				System.out.println(personelId + " nolu kişi bulunamamıştır.");
			}else {
				personel.setMaas(maas);
				tx.commit();
				System.out.println(personelId + " nolu personelin yeni maasi : " + maas);
			}
			

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
