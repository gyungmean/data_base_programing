package model;

/**
 * ����� ������ ���� �ʿ��� ������ Ŭ����. USERINFO ���̺�� ������
 */
public class User {
   private int user_id;              
   private String password;             
   private String nickname;             
   private String email;               
   private int region_id;           
   private int theme_id;    

   public User() { }      // �⺻ ������
   
   public User(int user_id, String password, String nickname, String email, int region_id, int theme_id) {
      super();
      this.user_id = user_id;
      this.password = password;
      this.nickname = nickname;
      this.email = email;
      this.region_id = region_id;
      this.theme_id = theme_id;
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

   public int getRegion_id() {
      return region_id;
   }

   public void setRegion_id(int region_id) {
      this.region_id = region_id;
   }

   public int getTheme_id() {
      return theme_id;
   }

   public void setTheme_id(int theme_id) {
      this.theme_id = theme_id;
   }
   
   /*public void update(User updateUser) {
    this.password = updateUser.password;
    this.name = updateUser.name;
    this.email = updateUser.email;
    this.phone = updateUser.phone;
   }*/

   /* ��й�ȣ �˻� */
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
      return "User [userId=" + user_id + ", password=" + password + ", nickname=" + nickname + ", email=" + email + ", region_id="
            + region_id + ", theme_id=" + theme_id + "]";
   }   
}
