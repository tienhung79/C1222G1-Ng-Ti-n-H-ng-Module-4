package mail.repository;

import mail.model.Mail;

import java.util.List;

public interface IRepositoryMail {
    Mail getMail();

    List<String> getLanguageList();

    List<Integer> getPageSizeList();


    void update(Mail mail);
}
