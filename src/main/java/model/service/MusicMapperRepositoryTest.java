package model.service;

public class MusicMapperRepositoryTest {
	static MusicManager musicMan = MusicManager.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MusicMapperRepository starts...");
		
		try {
//			musicMan.insertMusic("擠學薯跡3", "擠學url3", "33", 1);
//			musicMan.insertMusic("擠學薯跡4", "擠學url4", "44", 1);
			
//			musicMan.updateMusic(1, "擠學url1 熱薑");
			
//			musicMan.deleteMusic(1);
			
			System.out.println(musicMan.selectMusicByMusicTag("3"));
			
//			musicMan.deleteAllMusics();
		} finally {
			
		}
	}

}
