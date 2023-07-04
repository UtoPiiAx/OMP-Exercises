package Aufgabe1und2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;

public class Lecture {

	private String number = "";
	private String title = "";
	private String shortTitle = "";
	private String semester = "";
	private List<Lecturer> lecturers = new ArrayList<>();
	private List<Date> schedule = new ArrayList<>();

	public Lecture(String number, String title, String shortTitle, String semester) {
		super();
		this.number = number;
		this.title = title;
		this.shortTitle = shortTitle;
		this.semester = semester;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public List<Date> getSchedule() {
		return schedule;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(number);
		result.append(": ");
		result.append(title);
		result.append(" (");
		result.append(shortTitle);
		result.append("), ");
		result.append(semester);
		result.append("\n\t");
		for (int i = 0; i < lecturers.size(); i++) {
			if (i > 0) {
				result.append(", ");
			}
			result.append(lecturers.get(i));
		}
		for (Date date : schedule) {
			result.append("\n\t- ");
			result.append(date);
		}
		result.append("\n");
		return result.toString();
	}

	public static void save (String filename, Lecture data) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(filename);
			save(out, data);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static void save (OutputStream out, Lecture data) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(out));
		dos.writeUTF(data.getNumber());
		dos.writeUTF(data.getTitle());
		dos.writeUTF(data.getShortTitle());
		dos.writeUTF(data.getSemester());
		dos.writeInt(data.getLecturers().size());
		for (Lecturer lecturer : data.getLecturers()) {
			lecturer.save(dos);
		}
		dos.writeInt(data.getSchedule().size());
		for (Date date : data.getSchedule()) {
			date.save(dos);
		}
		dos.flush();
	}
	public static Lecture load(String filename) throws IOException {
		Lecture result = null;
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			result = load(in);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	private static Lecture load(InputStream in) throws IOException {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(in));
		Lecture result = new Lecture(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readUTF());
		int size;
		size = dis.readInt();
		for (int i = 0; i < size; i++) {
			Lecturer lecturer = new Lecturer ();
			lecturer.load(dis);
			result.getLecturers().add(lecturer);
		}
		size = dis.readInt();
		for (int i = 0; i < size; i++) {
			Date date = new Date ();
			date.load(dis);
			result.getSchedule().add(date);
		}
		return result;
	}

	/*
	Annahmen:
	- die Datei ist im UTF-8 Format kodiert
	- alle Daten sind vollständig, d.h. es fehlen keine Zeilen
	- alle Daten enthalten keine Zeilenumbrüche
	- Dozentennamen duerfen keine Leerzeichen und Kommata enthalten
	- Termine sind genau entsprechend der Date.toString()-Methode formatiert
	- Hoersaalnamen haben keine eckigen Klammern
	- Themen duerfen keine eckigen Klammern und Kommata enthalten
	 */
	public static void saveText(String filename, Lecture data) throws IOException {
		Path file = Paths.get(filename);
		List<String> lines = new ArrayList<>();
		lines.add(data.getNumber());
		lines.add(data.getTitle());
		lines.add(data.getShortTitle());
		lines.add(data.getSemester());
		String lecturers = "";
		for (int i = 0; i < data.getLecturers().size(); i++) {
			if (i > 0) {
				lecturers += ", ";
			}
			lecturers += data.getLecturers().get(i);
		}
		lines.add(lecturers);
		for (Date date : data.getSchedule()) {
			lines.add(date.toString());
		}
		Files.write(file, lines);
	}

	public static Lecture loadText(String filename) throws IOException {
		Path file = Paths.get(filename);
		List<String> lines = Files.readAllLines(file);
		Iterator<String> content = lines.iterator();
		Lecture result = new Lecture(content.next(), content.next(), content.next(), content.next());
		String [] lecturers = content.next().split("\\");
		if (lecturers != null) {
			for (String lecturer : lecturers) {
				String [] names = lecturer.strip().split("\\s");
				if (names != null && names.length >= 2) {
					result.getLecturers().add(new Lecturer(names[0], names[1]));
				}
			}
		}
		while (content.hasNext()) {
			String line = content.next();
			Date date = new Date();
			int posStart = 0;
			int posStop = line.indexOf('-');
			date.setYear(Integer.parseInt(line.substring(posStart, posStop)));
			posStart = posStop + 1;
			posStop = line.indexOf('-', posStart);
			date.setMonth(Integer.parseInt(line.substring(posStart, posStop)));
			posStart = posStop + 1;
			posStop = line.indexOf(' ', posStart);
			date.setDay(Integer.parseInt(line.substring(posStart, posStop)));
			posStart = posStop + 1;
			posStop = line.indexOf(':', posStart);
			date.setHour(Integer.parseInt(line.substring(posStart, posStop)));
			posStart = line.indexOf(',') + 2;
			posStop = line.indexOf('[', posStart) - 1;
			date.setLectureHall(line.substring(posStart, posStop));
			posStart = line.indexOf('[') + 1;
			posStop = line.indexOf(']');
			String [] topics = line.substring(posStart, posStop).split("\\,");
			if (topics != null) {
				for (String topic : topics) {
					date.getTopics().add(topic.strip());
				}
			}
			result.getSchedule().add(date);
		}
		return result;
	}
}