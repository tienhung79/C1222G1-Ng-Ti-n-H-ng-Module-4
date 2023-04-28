package com.example.repository.iml;

import com.example.repository.IRepository;

public class Repository implements IRepository {


    @Override
    public String check(String englishCheck) {
        String[] vietnamese = {"xe hơi","xe máy","xe ô tô","máy bay"};
        String[] english = {"car","motobike","audi","plane"};
        String message = "Không tìm thấy";
        for (int i = 0; i < vietnamese.length; i++) {
            if (english[i].equals(englishCheck)) {
                return vietnamese[i];
            }
        }
        return message;
    }
}
