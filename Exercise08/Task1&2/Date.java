package Aufgabe1und2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Date {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private String lectureHall = "";
	private List<String> topics = new ArrayList<>();
	
	public Date() {
		super();
	}
	
	public Date(int year, int month, int day, int hour, String lectureHall) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.lectureHall = lectureHall;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getLectureHall() {
		return lectureHall;
	}

	public void setLectureHall(String lectureHall) {
		this.lectureHall = lectureHall;
	}

	public List<String> getTopics() {
		return topics;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(year);
		result.append("-");
		result.append(month);
		result.append("-");
		result.append(day);
		result.append(" ");
		result.append(hour);
		result.append(":00, ");
		result.append(lectureHall);
		result.append(" ");
		result.append(topics);
		return result.toString();
	}

	void save (DataOutputStream dos) throws IOException {
		dos.writeInt(year);
		dos.writeInt(month);
		dos.writeInt(day);
		dos.writeInt(hour);
		dos.writeUTF(lectureHall);
		dos.writeInt(topics.size());
		for (String topic : topics) {
			dos.writeUTF(topic);
		}
	}
	public void load(DataInputStream dis) throws IOException {
		year = dis.readInt();
		month = dis.readInt();
		day = dis.readInt();
		hour = dis.readInt();
		lectureHall = dis.readUTF();
		int topicsSize = dis.readInt();
		for (int i = 0; i < topicsSize; i++) {
			String topic = dis.readUTF();
			topics.add(topic);
		}
	}
}
