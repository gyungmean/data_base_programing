package model.service;

public class MusicMapperRepositoryTest {
	static MusicManager musicMan = MusicManager.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MusicMapperRepository starts...");
		
		try {
//			musicMan.insertMusic("��������3", "����url3", "33", 1);
//			musicMan.insertMusic("��������4", "����url4", "44", 1);
			
//			musicMan.updateMusic(1, "����url1 ����");
			
//			musicMan.deleteMusic(1);
			
			System.out.println(musicMan.selectMusicByMusicTag("3"));
			
//			musicMan.deleteAllMusics();
		} finally {
			
		}
	}

}
