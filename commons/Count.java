package commons;

import java.io.File;

public class Count {
	public static void main(String[] args) {
		File file = new File("G:\\EclipseProject\\Coding Interviews\\src");
		File[] files = file.listFiles();
		int dircount = 0;
		int quescount = 0;
		for (File f: files) {
			if(f.getName().startsWith("question")) {
				dircount++;
				quescount += f.listFiles().length;
			}
			
		}
		System.out.println("��Ŀ������"+dircount);
		System.out.println("ʵ������������"+quescount);
	}
}
