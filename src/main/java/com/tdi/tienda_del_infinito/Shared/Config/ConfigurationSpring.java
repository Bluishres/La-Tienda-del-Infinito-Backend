package com.tdi.tienda_del_infinito.Shared.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.tdi.*")
@EnableJpaAuditing(auditorAwareRef = "customAuditorAware")
@EnableTransactionManagement
@Import(value = {ConfigurationPersistence.class})
public class ConfigurationSpring {
}
