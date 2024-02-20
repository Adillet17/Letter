package Letter.demo;
@Component
public class PersonValidator implements Validator{
    private final PersonService personService;

    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonModel.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        PersonModel person = (PersonModel) object;
        PersonModel personInBase = personService.findOneByName(person.getName());
        if (personInBase == null) {
            errors.rejectValue("name", "", "Читатель с таким ФИО не найден");
        }
    }
}
