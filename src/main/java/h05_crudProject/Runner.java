package h05_crudProject;

public class Runner {

	public static void main(String[] args) {
		
		CrudMethods method = new CrudMethods();
		method.sessionFactoryOlustur();
//		
//		method.personelEkle("Ahmet", "Yılmaz", 5500);
//		method.personelEkle("Mustafa", "Baki", 7200);
//		method.personelEkle("Can", "Ali", 4450);
		
//		method.idIlePersonelSil(4l);
//		method.idIlePersonelSil(6l);
//		method.idIlePersonelSil(12l);
		
//		method.tumPersoneliListele();
		
//		method.idIlePersonelListele(5L);
		
		method.idIleMaasGuncelleme(3l, 6340);
		method.tumPersoneliListele();
	}
}
