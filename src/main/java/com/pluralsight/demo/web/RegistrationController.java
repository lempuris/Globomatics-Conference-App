package com.pluralsight.demo.web;

import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.demo.model.AttendeeRegistration;
import com.pluralsight.demo.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {
	private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

	// private final RegistrationService registrationService;

	private final MessageChannel registrationRequestChannel;

	public RegistrationController(@Qualifier("registrationRequest") MessageChannel registrationRequestChannel) {
		this.registrationRequestChannel = registrationRequestChannel;
	}

	@GetMapping
	public String index(@ModelAttribute("registration") AttendeeRegistration registration) {
		return "index";
	}

	@PostMapping
	public String submit(@ModelAttribute("registration") @Valid AttendeeRegistration registration,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOG.warn("Validation failed: {}", bindingResult);
			return "index";
		}

	 Message<AttendeeRegistration> message = MessageBuilder.withPayload(registration)
			 .setHeader("dateTime", OffsetDateTime.now())
			 .build();
		registrationRequestChannel.send(message);

		// registrationService.register(registration);

		return "success";
	}
}
