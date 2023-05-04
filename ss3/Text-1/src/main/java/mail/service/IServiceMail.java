package mail.service;

import mail.model.Mail;

import java.util.List;

public interface IServiceMail {
    Mail getAll();

    List<String> getLanguagList();

    List<Integer> getPagaSizeList();


    void update(Mail mail);
}
