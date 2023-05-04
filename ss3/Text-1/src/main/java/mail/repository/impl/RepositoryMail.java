package mail.repository.impl;

import mail.model.Mail;
import mail.repository.IRepositoryMail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositoryMail implements IRepositoryMail {
    private  Mail mail = new Mail("English",25,"","King,Asgard");
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> pageSize = new ArrayList<>();
    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public Mail getMail() {
        return mail;
    }

    @Override
    public List<String> getLanguageList() {
        return languages;
    }

    @Override
    public List<Integer> getPageSizeList() {
        return pageSize;
    }

    @Override
    public void update(Mail mail) {
        this.mail=mail;
    }
}
