package src;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) throws IOException {

        String filename = "popular_words.txt";
        createFile(filename);
        File file = new File(filename);

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        //miałam wywołać zapytanie dla wybranych serwisów internetowych i próbowałam znaleźć jakiś inny niż onet, który tu działa ale mi sie nie udało
        fillFile(connect,filename);

        String filename2 = "filtered_popular_words.txt";
        createFile(filename2);

        filterFile(file, filename2);
    }

    static void createFile (String filename) throws IOException {
        Path path = Paths.get(filename);
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    static void fillFile (Connection connect, String filename) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(filename);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String headline = elem.text();
                String[] tokens = headline.split(" ");
                for (String token : tokens){
                    token = token.replaceAll("\\.|,|-|\"|;|:|\\?|!|\\||'|[0-9]+","");
                    //jak chciałam, żeby usunął wszystko co nie jest literą to skasował mi polskie znaki, więc poradziłam sobie tak pokracznie :)
                    if(token.length()>0){
                        printWriter.println(token);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.close();
    }

    static void filterFile(File file, String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        PrintWriter printWriter = new PrintWriter(filename);
        String[] restrictedWords = {"oraz", "ponieważ", "dla", "ale", "nie", "się", "jak"};

        while (scanner.hasNext()){
            String word = scanner.nextLine();
            boolean isItRestricted = false;
            for (int i = 0; i < restrictedWords.length ; i++) {
                if(word.equalsIgnoreCase(restrictedWords[i])){
                    isItRestricted = true;
                }
            }
            if (word.length()>=3 && !isItRestricted){
                printWriter.println(word);
            }
        }

        printWriter.close();
        scanner.close();
    }

}
