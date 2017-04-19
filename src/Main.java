import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static int totalClintonWords = 117418;
    public static int totalTrumpWords = 163458;
    
    public static void main(String[] args) {
        int clintonNumber = findOccurances("/Users/dylanmilligan/Downloads/PSCI speeches/clinton_2016", "famil");
        int trumpNumber = findOccurances("/Users/dylanmilligan/Downloads/PSCI speeches/trump_2016", "famil");
        System.out.println("Trump: " + trumpNumber + " Clinton: " + clintonNumber);
    }
    
    public static int findOccurances(String filepath, String word) {
        File speechFiles = new File(filepath);
        File[] candidateSpeeches = speechFiles.listFiles();
        int wordCount = 0;
        for (File f : candidateSpeeches) {
            if(f.isFile()) {
                String speech = "";
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(f)); 
                    String next;
                    while((next = br.readLine()) != null) {
                        speech += next;
                    }
                    String[] speechWords = speech.split(" ");
                    for(int i = 0 ; i < speechWords.length; i++) {
                        if(speechWords[i].toLowerCase().contains(word)) {
                            wordCount++;
                        }
                    }
                } catch(IOException e) {
                    System.out.println("IO Exception");
                }
            }
        }
        return wordCount;
    }
}
