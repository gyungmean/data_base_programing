package model;

public class Course {
   private int course_id;           
   private String course_name;
   private String departure;
   private String stopover;           
   private String destination;
   private String time;                 
   private int parking;             
   private int like_count;  
   private int region_id;           
   private int theme_id;
   
   public Course(int course_id, String course_name, String departure, String stopover, String destination, String time,
         int parking, int like_count, int region_id, int theme_id) {
      super();
      this.course_id = course_id;
      this.course_name = course_name;
      this.departure = departure;
      this.stopover = stopover;
      this.destination = destination;
      this.time = time;
      this.parking = parking;
      this.like_count = like_count;
      this.region_id = region_id;
      this.theme_id = theme_id;
   }

   public int getCourse_id() {
      return course_id;
   }

   public void setCourse_id(int course_id) {
      this.course_id = course_id;
   }

   public String getCourse_name() {
      return course_name;
   }

   public void setCourse_name(String course_name) {
      this.course_name = course_name;
   }

   public String getDeparture() {
      return departure;
   }

   public void setDeparture(String departure) {
      this.departure = departure;
   }

   public String getStopover() {
      return stopover;
   }

   public void setStopover(String stopover) {
      this.stopover = stopover;
   }

   public String getDestination() {
      return destination;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public int getParking() {
      return parking;
   }

   public void setParking(int parking) {
      this.parking = parking;
   }

   public int getLike_count() {
      return like_count;
   }

   public void setLike_count(int like_count) {
      this.like_count = like_count;
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
 
}