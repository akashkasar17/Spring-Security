package com.security.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String code) {//, null, Locale.ENGLISH
		return messageSource.getMessage(code, null, Locale.ENGLISH);
	}

}
