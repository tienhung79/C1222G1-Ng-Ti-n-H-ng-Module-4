package sandwich.service.iml;

import org.springframework.stereotype.Service;
import sandwich.repository.ISandwichRepository;
import sandwich.repository.iml.SandwichRepository;
import sandwich.service.ISanfwichService;

import java.util.List;

@Service

public class SandwichService implements ISanfwichService {
    ISandwichRepository sandwichRepository = new SandwichRepository();
    @Override
    public List<String> getSpiceList() {
        return sandwichRepository.getSpiceList();
    }
}
