package listem;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public abstract class Commands {


  public Commands() {

  }
  /* We want to load all the files and directories to a list
   * then go through that list and if we have recursive == true
   * then we will traverse again with the new directory
   * if the file name matches the regex - then we will
   * read that file and process it with an abstract method;
   */
  public void traverse(File file, String pattern, boolean recursive) {
    try {
      File[] dirs = file.listFiles();
      for (File f : dirs) {
        if (f.isFile()) {
          String name = f.getName();
          if (name.matches(pattern)) {
            makeList();
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
              String tmp = sc.nextLine();
              processLine(tmp);
              //dirs = this.dir.listFiles();
              //System.out.println(dirs);
            }
            appendList(f);
            sc.close();
          }
        } else if (recursive == true) {
          if (f.isDirectory()) {
            traverse(f, pattern, recursive);
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("No File");
    }
  }

  public abstract void processLine(String line);

  public abstract void appendList(File file);

  public abstract void makeList();
}
