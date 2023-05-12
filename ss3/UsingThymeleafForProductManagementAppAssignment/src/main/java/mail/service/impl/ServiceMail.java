package mail.service.impl;

import mail.model.Mail;
import mail.repository.IRepositoryMail;
import mail.service.IServiceMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceMail implements IServiceMail {
    @Autowired
    private IRepositoryMail repositoryMail;
    @Override
    public Mail getAll() {
        return repositoryMail.getMail();
    }

    @Override
    public List<String> getLanguagList() {
        return repositoryMail.getLanguageList();
    }

    @Override
    public List<Integer> getPagaSizeList() {
        return repositoryMail.getPageSizeList();
    }

    @Override
    public void update(Mail mail) {
        repositoryMail.update(mail);
    }


}
