import java.util.Scanner;
import java.io.*;

public class lab2 {

   public static void main(String[] args) throws FileNotFoundException {

       int numberOfFiles = 2;
       for(int i=1;i<=numberOfFiles;i++){

       }
       Scanner sc = new Scanner(System.in);
       //loading name of file
       File file = new File("lab2_chart.txt"); //reading data from this file
       Scanner reader;
       String line="";

   	   PrintWriter outputFile = new PrintWriter("Artists-WEEKof09062020.txt");  //write data to this file

       
       int maxArtist = 500;

       String artists[] = new String[maxArtist];
       int artistsCount[] = new int[maxArtist];

       int currentIndex=0;
       
       //reset count to zero
       
       for(int i=0;i<artistsCount.length;i++){
           artistsCount[i] = 0;
       }                                           
       int songRecordCount=0;

       try {
           reader = new Scanner(file);
           while(reader.hasNextLine()){
               songRecordCount++;		//record total number of songs
               
               //read line
               line = reader.nextLine();
               String cols[] = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

               //Artist will be at column 2
               String tmpArtist = cols[2];

               //remove quotes from the line
               tmpArtist = tmpArtist.replaceAll("\"", "");
               for(String art : tmpArtist.split(",")){
                   boolean found = false;
                   for(int i=0;i<currentIndex;i++){
                       if(art.equalsIgnoreCase(artists[i])){
                           artistsCount[i]++;
                           found = true;
                           break;
                       }
                   }
                   if(!found){
                       artists[currentIndex] = art;
                       artistsCount[currentIndex]=1;
                       currentIndex++;
                   }
               }
           }
       } catch (FileNotFoundException e) {
           System.out.println("file not found");
       }

      
       outputFile.println("Total song: "+songRecordCount);
       
       outputFile.println("Total artists is: "+currentIndex);		//set up the format of outputfile
       
       outputFile.printf("%-22s%s\n","Artist"," occurrence");
       for(int i=0;i<currentIndex;i++){
    	   outputFile.printf("%-27s%s\n",artists[i],artistsCount[i]);
       }
       sc.close();
       outputFile.close();
   }


}
