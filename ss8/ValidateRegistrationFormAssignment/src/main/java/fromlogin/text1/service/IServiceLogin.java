package fromlogin.text1.service;

import fromlogin.text1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceLogin {

    Page<User> getLoginPage(Pageable pageable);

    User getById(int id);

    void update(User login);

    void creatUser(User user);
}
