package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.business.RandomDataService;
import pl.zajavka.business.ReloadDataService;
import pl.zajavka.infrastructure.configuration.ApplicationConfiguration;

public class ZajavkaStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        ReloadDataService reloadDataService = context.getBean(ReloadDataService.class);
        reloadDataService.loadRandomData();
    }
}
