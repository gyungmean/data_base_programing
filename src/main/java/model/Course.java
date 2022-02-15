package model;

import java.util.List;

public class Course {
   private int course_id;           
   private String course_name;
   private String departure;
   private String stopover;           
   private String destination;
   private String time;                 
   private int parking;              
   private int region_id;
   private List<Theme> themeList;
   private int user_id;
   private String url;
   
   public Course() { }
   
   public Course(int course_id, String course_name, String departure, String stopover, String destination, String time,
		   int parking, int region_id, List<Theme> themeList, int user_id, String url) {
      super();
      this.course_id = course_id;
      this.course_name = course_name;
      this.departure = departure;
      this.stopover = stopover;
      this.destination = destination;
      this.time = time;
      this.parking = parking;
      this.region_id = region_id;
      this.themeList = themeList;
      this.user_id = user_id;
      this.url = url;
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

   public int getRegion_id() {
      return region_id;
   }

   public void setRegion_id(int region_id) {
      this.region_id = region_id;
   }

   public List<Theme> getThemeList() {
      return themeList;
   }

   public void setThemeList(List<Theme> themeList) {
      this.themeList = themeList;
   }

	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String toString() {
		return course_id
				+ " "   + course_name
				+ " "   +  departure
				+ " "   +  stopover
				+ " "   +  destination
				+ " "   +  time
				+ " "   +  parking
				+ " "   +  region_id
				+ " "   +  themeList
				+ " "   +  user_id + "\n";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}