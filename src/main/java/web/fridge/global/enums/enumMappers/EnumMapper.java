package web.fridge.global.enums.enumMappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.fridge.global.enums.Status;
import web.fridge.global.enums.enumMappers.EnumMapperFactory;

import java.util.LinkedHashMap;

@Configuration
public class EnumMapper {

    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory enumMapperFactory = new EnumMapperFactory(new LinkedHashMap<>());
        enumMapperFactory.put("Status", Status.class);
        return enumMapperFactory;
    }

}
