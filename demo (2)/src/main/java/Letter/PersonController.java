package Letter.demo;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yurtahome")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/letter")
    public String letterPerson(@ModelAttribute("person") PersonModel person) {
        return "yurtahome/letter";
    }

    @PostMapping()
    public String createLetter(@RequestParam("country") String country,
                               @ModelAttribute("person") @Valid PersonModel person,
                               BindingResult bindingResult, Model model) {

        validator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "yurtahome/letter";


        personService.save(person);

        String message;
        switch (country) {
            case "australia":
                message = "Вы выбрали загрузку фото/видео.";
                break;
            case "canada":
                message = "Вы выбрали написать отзыв на продукцию.";
                break;
            case "usa":
                message = "Вы выбрали письмо на новоселье или написать о ноу-хау.";
                break;
            default:
                message = "Выбран неизвестный вариант.";
        }


        model.addAttribute("message", message);

        return "redirect:/yurtahome/#soob";
    }
}
