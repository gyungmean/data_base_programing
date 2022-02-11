package model;

public class Music {
	private int musicId;
	private String musicTitle;
	private String musicUrl;
	private String musicTag;
	private int userId;
	
	public Music() {}
	
	public Music(int musicId, String musicTitle, String musicUrl, String musicTag, int userId) {
		super();
		this.musicId = musicId;
		this.musicTitle = musicTitle;
		this.musicUrl = musicUrl;
		this.musicTag = musicTag;
		this.userId = userId;
	}

	public int getMusicId() {
		return musicId;
	}
	
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	
	public String getMusicTitle() {
		return musicTitle;
	}
	
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	
	public String getMusicUrl() {
		return musicUrl;
	}
	
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	
	public String getMusicTag() {
		return musicTag;
	}
	
	public void setMusicTag(String musicTag) {
		this.musicTag = musicTag;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Music [musicId=" + musicId + ", musicTitle=" + musicTitle + ", musicUrl=" + musicUrl + ", musicTag="
				+ musicTag + ", userId=" + userId + "]";
	}
}
