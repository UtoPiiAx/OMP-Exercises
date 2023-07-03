import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.stream.Stream;

public class LibQuery {

	public static void main(String[] args) {
		Library lib = new Library();
		BookShelf shelf = new BookShelf();
		lib.getShelves().add(shelf);
		Author alanTuring = new Author("Alan", "Turing");
		Author alonzoChurch = new Author("Alonzo", "Church");
		Author konradZuse = new Author("Konrad", "Zuse");
		Author edsgerDijkstra = new Author("Edsger", "Dijkstra");
		Publication turing1 = new Book("The Turing Machine", 1940, alanTuring, 250);
		Publication turing2 = new Book("Breaking Ciphers", 1942, alanTuring, 150);
		Publication turing3 = new Journal("Theoretical Computer Science", 1950, alanTuring, 50);
		Publication church1 = new Book("Entscheidungsproblem", 1960, alonzoChurch, 30);
		Publication church2 = new Book("Lambda Calculus", 1962, alonzoChurch, 80);
		Publication church3 = new Journal("Church–Turing Thesis", 1948, alonzoChurch, 110);
		church3.getAuthors().add(alanTuring);
		Publication church4 = new Journal("Frege–Church Ontology", 1980, alonzoChurch, 200);
		Publication zuse1 = new Book("Turing-complete Z3", 1941, konradZuse, 100);
		Publication zuse2 = new Book("Rechnender Raum", 1969, konradZuse, 150);
		Publication dijkstra1 = new Book("Compiler Construction", 1950, edsgerDijkstra, 150);
		Publication dijkstra2 = new Book("Concurrent Programming", 1960, edsgerDijkstra, 250);
		Publication dijkstra3 = new Journal("Graph Algorithms", 1970, edsgerDijkstra, 70);
		dijkstra3.getAuthors().add(new Author("Kozo", "Sugiyama"));
		
		church1.addReference(turing1);
		church3.addReference(turing1);
		zuse1.addReference(turing1);
		dijkstra3.addReference(turing3);
		
		shelf.getItems().add(turing1);
		shelf.getItems().add(turing2);
		shelf.getItems().add(turing3);
		shelf.getItems().add(church1);
		shelf.getItems().add(church2);
		shelf.getItems().add(church3);
		shelf.getItems().add(church4);
		shelf.getItems().add(zuse1);
		shelf.getItems().add(zuse2);
		shelf.getItems().add(dijkstra1);
		shelf.getItems().add(dijkstra2);
		shelf.getItems().add(dijkstra3);
		
		// Gib die Titel aller Publikationen von Alan Turing aus, sortiert nach Datum
		shelf.getItems().stream()
			.filter((p) -> p.getAuthors().contains(alanTuring))
			.sorted((p1, p2) -> Integer.compare(p1.getYear(), p2.getYear()))
			.forEach((p) -> System.out.println(p.getTitle()));
		System.out.println();
		
		// Gib aus, wie viele Bücher mit mehr als 100 Seiten es gibt, die mindestens zwei Autoren haben
		long count = shelf.getItems().stream()
			.filter((p) -> p.getPages().size() > 100)
			.filter((p) -> p.getAuthors().size() >= 2)
			.count();
		System.out.println(count);
		System.out.println();
		
		// Gib die Namen aller Autoren aus, die Publikationen geschrieben haben, die von mindestens drei anderen Publikationen referenziert werden
		shelf.getItems().stream()
			.filter((p) -> p.getReferencedBy().size() >= 3)
			// optional: diese Publikationen dürfen keinen Autor mit der referenzierten Publikation gemeinsam haben (keine Selbstreferenzen)
			.filter((p) -> p.getReferencedBy().stream().filter((r) -> { return !intersection(p.getAuthors(), r.getAuthors()); }).count() >= 3)
			.map((p) -> p.getAuthors().stream())
			.reduce((s1, s2) -> Stream.concat(s1, s2))
			.orElse(Stream.empty())
			.distinct()
			.forEach((a) -> System.out.println(a));
		System.out.println();
		
		// Hole den Stream aus der Bibliothek, nicht direkt aus einem Regal
		lib.getShelves().stream()
			.map((s) -> s.getItems().stream())
			.reduce((s1, s2) -> Stream.concat(s1, s2))
			.orElse(Stream.empty())
			.forEach((p) -> System.out.println(p.getTitle()));
		System.out.println();
		
		// Schreibe eine Publikation (mit Seiten, Autoren und ein- und ausgehenden Referenzen) in eine Datei
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("lib.ser")))) {
			out.writeObject(turing1);
		} catch (FileNotFoundException e) {
			System.err.println("The file could not be opened!");
		} catch (IOException e) {
			System.err.println("Error writing to the file!");
		}

		// Lade die Publikation wieder aus der Datei und gebe Titel, Autoren und Anzahl der ein- und ausgehenden Referenzen aus
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("lib.ser")))) {
			Publication pub = (Publication) in.readObject();
			System.out.println(pub.getTitle());
			System.out.println(pub.getAuthors());
			System.out.println(pub.getReferences().size());
			System.out.println(pub.getReferencedBy().size());
		} catch (FileNotFoundException e) {
			System.err.println("The file could not be opened!");
		} catch (IOException e) {
			System.err.println("Error writing to the file!");
		} catch (ClassNotFoundException e) {
			System.err.println("Java class not available!");
		}
	}
	
	private static <T> boolean intersection(Collection<T> c1, Collection<T> c2) {
		for (T d1 : c1) {
			if (c2.contains(d1)) {
				return true;
			}
		}
		return false;
	}

}
