package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Reply implements Serializable {
   private Long replyId;
   private Long commentNo;
   private int userId;
   private String replyContent;
   private Date regDate;
   
   public Reply() { }
   
   public Reply(Long replyId, Long commentNo, int userId, String replyContent, Date regDate) {
      super();
      this.replyId = replyId;
      this.commentNo = commentNo;
      this.userId = userId;
      this.replyContent = replyContent;
      this.regDate = regDate;
   }
   
   public Long getReplyId() {
      return replyId;
   }
   public void setReplyId(Long replyId) {
      this.replyId = replyId;
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
   
   public String getReplyContent() {
      return replyContent;
   }
   public void setReplyContent(String replyContent) {
      this.replyContent = replyContent;
   }
   
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   
   @Override
   public String toString() {
      return "Reply [replyId=" + replyId + ", commentNo=" + commentNo + ", userId=" + userId
            + ", replyContent=" + replyContent + ", regDate=" + regDate + "]";
   }
}