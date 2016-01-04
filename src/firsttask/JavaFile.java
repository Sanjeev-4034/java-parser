package firsttask;

import java.io.IOException;

public class JavaFile extends FileParser {

	public static void main(String[] args) throws IOException {
		FileParser s = new FileParser();
		s.listPackages();
		s.listFiles();
		s.detectLocalFiles();
	}
}
