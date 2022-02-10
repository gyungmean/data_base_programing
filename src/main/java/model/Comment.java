package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Comment implements Serializable {
	private Long commentNo;
	private int userId;
	private Date regDate;
	private String commentContent;
	private User user;  			// User 객체 참조
	private List<Reply> replies;	// Reply 객체들의 list 참조
	private String title;
	private Course course;	//course 객체 참조
	private int courseId;
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", userId=" + userId + ", regDate=" + regDate + ", " + "courseId=" + courseId 
				+ ", title=" + title + ", commentContent=" + commentContent + ", \n user=" + user + ", replies=" + replies + "]";
	}	
}