package com.example.fajar.quizfix;

import java.util.Random;

/**
 * Created by Fajar on 5/8/2017.
 */

public class QuizBank {

    //array untuk pertanyaan
    private String squestion [] = {
                "Ibu kota provinsi Jawa Barat?",
                "Ibu kota provinsi Sumatera Barat?",
                "Ibu kota provinsi Kalimantan Barat?",
                "Ibu kota provinsi Sulawesi Barat?",
                "Ibu kota provinsi Nusa Tenggara Barat?"
    };

    //array untuk pilihan jawaban atau opsional
    private String schoice [][] = {
            {"Bandung", "Semarang", "Surabaya", "Jakarta"},
            {"Palembang", "Pekanbaru", "Medan", "Padang"},
            {"Balikpapan", "Samarinda", "Pontianak", "Palangkaraya"},
            {"Makassar", "Mamuju", "Kendari", "Manado"},
            {"Bima", "Sumbawa", "Mataram", "Lombok"}
    };

    //array untuk jawaban yang benar
    private String scorrect [] = {
            "Bandung", "Padang", "Pontianak", "Mamuju", "Mataram"
    };

    //method untuk mengembalikan nilai dari pertanyaan
    public int getLength() {
        return squestion.length;
    }

    //method untuk mengembalikan pertanyaan dari array
    public String getQuestion (int a) {
        String question = squestion[a];
        return question;
    }

    //method untuk mengembalikan pilihan dari array
    public String getChoice (int index, int num) {
        String choice = schoice[index][num-1];
        return choice;
    }

    //method untuk mengembalikan jawaban dari array
    public String getCorret (int a) {
        String answer = scorrect[a];
        return answer;
    }
}
