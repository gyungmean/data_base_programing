package model;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class User {
   private int user_id;              
   private String password;             
   private String nickname;             
   private String email;                

   public User() { }      // 기본 생성자
   
   public User(int user_id, String password, String nickname, String email) {
      super();
      this.user_id = user_id;
      this.password = password;
      this.nickname = nickname;
      this.email = email;
   }
   
   public int getUser_id() {
      return user_id;
   }

   public void setUser_id(int user_id) {
      this.user_id = user_id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   
   /*public void update(User updateUser) {
    this.password = updateUser.password;
    this.name = updateUser.name;
    this.email = updateUser.email;
    this.phone = updateUser.phone;
   }*/

   /* 비밀번호 검사 */
   public boolean matchPassword(String password) {
      if (password == null) {
         return false;
      }
      return this.password.equals(password);
   }

   public boolean isSameUser(int userid) {
        return (this.user_id == userid);
    }

   @Override
   public String toString() {
      return "User [userId=" + user_id + ", password=" + password + ", nickname=" + nickname + ", email=" + email + "]";
   }   
}
