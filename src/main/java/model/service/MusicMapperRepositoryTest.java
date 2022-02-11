package model.service;

public class MusicMapperRepositoryTest {
	static MusicManager musicMan = MusicManager.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MusicMapperRepository starts...");
		
		try {
//			musicMan.insertMusic("擠學薯跡1", "擠學url1", "擠學鷓斜1", 1);
//			musicMan.insertMusic("擠學薯跡2", "擠學url2", "擠學鷓斜2", 1);
			
//			musicMan.updateMusic(1, "擠學url1 熱薑");
			
//			musicMan.deleteMusic(1);
			
//			musicMan.selectMusicByMusicTag("擠學url");
			
			musicMan.deleteAllMusics();
		} finally {
			
		}
	}

}
