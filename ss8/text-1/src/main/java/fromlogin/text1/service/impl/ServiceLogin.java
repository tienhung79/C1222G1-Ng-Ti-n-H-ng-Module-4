package fromlogin.text1.service.impl;

import fromlogin.text1.model.User;
import fromlogin.text1.repository.IRepositoryLogin;
import fromlogin.text1.service.IServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceLogin implements IServiceLogin {
    @Autowired
    IRepositoryLogin repositoryLogin;

    @Override
    public Page<User> getLoginPage(Pageable pageable) {
        return repositoryLogin.findAll(pageable);
    }

    @Override
    public User getById(int id) {
        return repositoryLogin.findById(id).get();
    }

    @Override
    public void update(User login) {
        repositoryLogin.save(login);
    }

    @Override
    public void creatUser(User user) {
        repositoryLogin.save(user);
    }
}
