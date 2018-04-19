package edu.gcccd.csis;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class SelfAware implements Language{

    public static void main(String[] args) throws Exception {

        final String code = System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "main" + File.separator + "java" + File.separator +
                SelfAware.class.getName().replace(".", File.separator) + ".java";

        System.out.println(code);

        SelfAware sa = new SelfAware();
        try {
            sa.append(code, "\n//keyword occurrences" + " " + sa.occurrences(code));
        }catch(IOException except) {
            System.out.println("A fatal exception has occurred. The program is closing");
            System.exit(-1);
        }
        //sa.append(code,"\n//Keyword occurrences: " + sa.occurrences(code));

    }
    // this is all about how to read a file
    @Override
    public int occurrences(String sourceFile) throws IOException {
        int occurences = 0;
        Path p = Paths.get(sourceFile);
        String fileAsString = new String(Files.readAllBytes(p));

        // split file at all occurences of non word characters
        String[] words = fileAsString.split("\\W+");
        for(int i = 0; i < words.length; i++){

            for(int j = 0; j < ReservedWords.length; j++){
                if(words[i].equals(ReservedWords[j]))
                occurences++;
            }
        }
        return occurences;
    }

    // this is all about how to write a file
    @Override
    public void append(final String sourceFile, final String message) throws IOException {
        Path p = Paths.get(sourceFile);
       //for this assignment it might be a good idea to append
       Files.write(p,message.getBytes(), StandardOpenOption.APPEND);
    }
}