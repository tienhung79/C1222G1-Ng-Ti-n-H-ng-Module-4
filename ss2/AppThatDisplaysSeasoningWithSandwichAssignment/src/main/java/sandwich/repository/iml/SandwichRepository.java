package sandwich.repository.iml;

import org.springframework.stereotype.Repository;
import sandwich.repository.ISandwichRepository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class SandwichRepository implements ISandwichRepository {
   private static List<String> spice = new ArrayList<>();
   static {
       spice.add("lettuce");
       spice.add("tomato");
       spice.add("mustard");
       spice.add("sprouts");
   }

    @Override
    public List<String> getSpiceList() {
        return spice;
    }
}
