package com.nepse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dataSource.xml")
public class DefaultConfig {
	
//	@Bean(initMethod = "init")
//	public TemplateManager templateManager() {
//		FreemarkerManager templateEngine = new FreemarkerManager(
//				i18nTextProvider(), "UTF-8", new TemplateLoader[] {
//						
//						new ClassTemplateLoader(FreemarkerManager.class,"/com/bita/template") 
//				});
//		templateEngine.setDebug(developmentMode);
//		Map<String, TemplateModel> sharedVariables = new HashMap<String, TemplateModel>();
//		sharedVariables.put("getCurrentUserName", new CurrentUserFunction());
//                templateEngine.setSharedVariables(sharedVariables);
//		return templateEngine;
//	}

}
