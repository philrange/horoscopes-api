package horoscopes.api;

import java.util.List;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoroscopesController {

    private static final Gson gson = new Gson();

//    @PostMapping("/employees")
//    Employee newEmployee(@RequestBody Employee newEmployee) {
//        return repository.save(newEmployee);
//    }

//    @GetMapping("/employees/{id}")
//    Employee one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));
//    }

    @GetMapping("/horoscope/{id}")
    ResponseEntity<String> getHoroscope(@PathVariable Long id) {

//        return repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));

        Horoscope horoscope = new Horoscope(id, "horoscope-" + id);
        return ResponseEntity.ok(gson.toJson(horoscope));
    }

}
