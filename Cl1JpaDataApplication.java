package pe.edu.i202223255.cl1_jpa_data_mallma_isaac;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202223255.cl1_jpa_data_mallma_isaac.repository.CountryRepository;


import java.util.List;

@SpringBootApplication
public class Cl1JpaDataApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Cl1JpaDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        countryRepository.findById("ARG").ifPresentOrElse(
                countryArg -> {
                    System.out.println(" hablados en Argentina (ARG):");
                    countryArg.getLanguages().forEach(language ->
                            System.out.println("- " + language.getId().getLanguage()));
                },
                () -> {
                    System.out.println(" no encontrada. Lenguajes hablados :");
                    countryRepository.findById("PER").ifPresent(countryPeru ->
                            countryPeru.getLanguages().forEach(language ->
                                    System.out.println("- " + language.getId().getLanguage())));
                }
        );

        // Segunda consulta: deleteAllById
        List<String> countriesToDelete = List.of("COL", "ARG");
        countryRepository.deleteAllById(countriesToDelete);
        System.out.println("Países eliminados: COL, ARG.");


        System.out.println("Re-ejecutando la consulta después de la eliminación:");
        countryRepository.findById("ARG").ifPresentOrElse(
                countryArg -> {
                    System.out.println("Lenguajes hablados en Argentina :");
                    countryArg.getLanguages().forEach(language ->
                            System.out.println("- " + language.getId().getLanguage()));
                },
                () -> {
                    System.out.println("Argentina no encontrada. Lenguajes hablados:");
                    countryRepository.findById("PER").ifPresent(countryPeru ->
                            countryPeru.getLanguages().forEach(language ->
                                    System.out.println("- " + language.getId().getLanguage())));
                }
        );
    }
}
