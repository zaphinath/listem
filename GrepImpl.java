package listem;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class GrepImpl extends Commands implements Grep{

  private Map<File, List<String>> values;
  private List<String> list;
  private String sub;

  public GrepImpl() {

  }
	/**
	 * Find lines that match a given pattern in files whose names match another
	 * pattern
	 * 
	 * @param directory The base directory to look at files from
	 * @param fileSelectionPattern Pattern for selecting file names
	 * @param substringSelectionPattern Pattern to search for in lines of a file
	 * @param recursive Recursively search through directories
	 * @return A Map containing files that had at least one match found inside them.
	 * Each file is mapped to a list of strings which are the exact strings from
	 * the file where the <code>substringSelectionPattern</code> was found.
	 */
	public Map<File, List<String>> grep(File directory, String fileSelectionPattern, 
			String substringSelectionPattern, boolean recursive) {
    this.sub = substringSelectionPattern;
    values = new HashMap<File, List<String>>();      
    traverse(directory, fileSelectionPattern, recursive);
    //System.out.println(values.toString());
    return values;
  }
  
  public void processLine(String line) {
    if (line.contains(sub)) {
      list.add(line);
    }
  }

  public void appendList(File file) {
    //System.out.println(file.toString() + " " + list.toString());
    //System.out.println(list.toString());
    values.put(file, this.list);
    //list.clear();
  }

  public void makeList() {
    list = new ArrayList<String>();
  }
}
