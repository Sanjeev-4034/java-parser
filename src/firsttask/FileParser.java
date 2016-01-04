package firsttask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileParser {
	File folder;
	File listOfFiles[];
	FileInputStream fileinputstream;
	Logger logger;
	StringBuffer import_string, temp_char;
	String strings_array[];
	int n, l;

	FileParser() {
		logger = Logger.getLogger(FileParser.class.getName());
		import_string = new StringBuffer("import");
		temp_char = new StringBuffer();
		strings_array = new String[10];
		l = 0;
	}

	public void listFiles() {
		folder = new File("/home/sanjeevn/Desktop/sanjeevK/java");
		listOfFiles = folder.listFiles();
	}

	public void listPackages() throws IOException {
		try {
			// BufferedReader br=new BufferedReader(new
			// InputStreamReader(System.in));
			fileinputstream = new FileInputStream(new File("/home/sanjeevn/Desktop/sanjeevK/java/f1.java"));
			while ((n = fileinputstream.read()) != -1) {
				temp_char.append((char) n);
				if (temp_char.toString().trim().equals(import_string.toString().trim())) {
					while ((char) n != '\n') {
						n = fileinputstream.read();
						temp_char.append((char) n);
					}
					strings_array[l++] = temp_char.toString();
					temp_char.delete(0, temp_char.length());
				}
			}
		} catch (FileNotFoundException fnfe) {
			logger.log(Level.INFO, "no such file", fnfe);
		} catch (NullPointerException npe) {
			logger.log(Level.INFO, "No data", npe);
		}

	}

	public void detectLocalFiles() {
		for (File temp_file : listOfFiles) {
			if (temp_file.isFile()) {
				String file_name = temp_file.getName().toString();
				for (String pack_name : strings_array) {
					if (pack_name != null)
						if (pack_name.contains(file_name))
							System.out.println("local: " + file_name);
				}
			}
		}
	}
}
