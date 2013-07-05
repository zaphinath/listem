package listem;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class LineCounterImpl extends Commands implements LineCounter {
  
  private int count;
  private Map<File, Integer> values;
	/**
	 * Count the number of lines in files whose names match a given pattern.
	 * 
	 * @param directory The base directory to look at files from
	 * @param fileSelectionPattern Pattern for selecting file names
	 * @param recursive Recursively search through directories
	 * @return A Map containing files whose lines were counted. Each file is mapped
	 * to an integer which is the number of lines counted in the file.
	 */
	public Map<File, Integer> countLines(File directory, String fileSelectionPattern, 
			boolean recursive) {
    values = new HashMap<File, Integer>();
    traverse(directory, fileSelectionPattern, recursive);
    return values;    
    
  }

  public void processLine(String line) {
    this.count++;

  }

  public void appendList(File f) {
    values.put(f, count);
    this.count = 0;
  }
  public void makeList() {

  }
	
}
