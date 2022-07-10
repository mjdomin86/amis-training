package com.amis.wordle;

import com.amis.wordle.service.WordleService;
import com.diogonunes.jcolor.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.amis.wordle.client")
public class WordleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WordleApplication.class, args);
    }

    @Autowired
    WordleService wordleService;

    @Override
    public void run(String... args) throws Exception {
        int nOfTries=5;
        System.out.println(colorize("Iniciando el procesador cuántico...", GREEN_TEXT(), BLACK_BACK()));
        String word = wordleService.getRandomWord(5);
        System.out.println(word);
        System.out.println(colorize("Adivina la palabra de " + word.length() + " letras:",  GREEN_TEXT(), BLACK_BACK() ));

        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        for (int i = 1; i <= nOfTries && !success; i++) {
            String wordTry = scanner.next();

            char [] guessWord = {'_', '_', '_', '_', '_'};
            Attribute[] positionWord = {RED_TEXT(), RED_TEXT(), RED_TEXT(), RED_TEXT(), RED_TEXT()};
            System.out.println("Intento #" + i);


            success = evaluate(wordTry, word,guessWord, positionWord);

            for (int k = 0; k <25 ; k++) {
                System.out.print(colorize("🕒",GREEN_TEXT(), BLACK_BACK() ));
                try {
                    Thread.sleep(50);
                }catch (Exception e){

                }
            }
            System.out.println();


        }
    }

    private boolean evaluate(String wordTry, String word, char[] guessWord, Attribute [] positionsWord) {

        if(word.equals(wordTry) ){
            System.out.println("¡Correcto!");
            return true;
        }

        StringBuilder letterInWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            // Si la letra está en palabra pero no en la misma posición
            if (word.contains(String.valueOf(wordTry.charAt(i))) && wordTry.charAt(i) != word.charAt(i)) {
                guessWord[i] = wordTry.charAt(i);
                positionsWord[i] = YELLOW_TEXT();
            }
            else {
                //Si la letra está en esa posición
                if (wordTry.charAt(i) == word.charAt(i)) {
                    guessWord[i] = word.charAt(i);
                    positionsWord[i] = GREEN_TEXT();
                }
            }
        }

        //Imprimir palabra guessWord

        if (letterInWord.length() == 0 && guessWord.length == 0) {
            System.out.println("Lo sentimos, no hay coincidencias :(");
        } else {
            if (guessWord.length > 0) {
                for (int i = 0; i < guessWord.length; i++) {
                    System.out.print(colorize(String.valueOf(guessWord[i]), positionsWord[i]));
                }
            }
        }

        System.out.println();
        return false;
    }
}
