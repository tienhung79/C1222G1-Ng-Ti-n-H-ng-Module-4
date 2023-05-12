package fromlogin.text1.repository;

import fromlogin.text1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryLogin extends JpaRepository<User,Integer> {
}
