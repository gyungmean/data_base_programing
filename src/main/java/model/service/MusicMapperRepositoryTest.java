package model.service;

public class MusicMapperRepositoryTest {
	static MusicManager musicMan = MusicManager.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MusicMapperRepository starts...");
		
		try {
//			musicMan.insertMusic("��������1", "����url1", "�����±�1", 1);
//			musicMan.insertMusic("��������2", "����url2", "�����±�2", 1);
			
//			musicMan.updateMusic(1, "����url1 ����");
			
//			musicMan.deleteMusic(1);
			
//			musicMan.selectMusicByMusicTag("����url");
			
			musicMan.deleteAllMusics();
		} finally {
			
		}
	}

}
