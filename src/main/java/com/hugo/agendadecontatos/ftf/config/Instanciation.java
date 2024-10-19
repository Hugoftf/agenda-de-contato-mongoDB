package com.hugo.agendadecontatos.ftf.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hugo.agendadecontatos.ftf.model.Contact;
import com.hugo.agendadecontatos.ftf.repository.ContactRepository;

import jakarta.annotation.PostConstruct;

@Component
public class Instanciation {

	@Autowired
	private ContactRepository contactRepository;
	
	@PostConstruct
	public void init() {
		contactRepository.deleteAll();
		
		Contact contact1 = new Contact(null, "Hugo", "2198882288", "Hugo@gmail.com", "Rua A, 223");
		Contact contact2 = new Contact(null, "Ygor", "1133334288", "Ygor@gmail.com", "Rua B, 442");
		Contact contact3 = new Contact(null, "Sheila", "1322586688", "Hugo@gmail.com", "Rua C, 332");
		
		contactRepository.saveAll(Arrays.asList(contact1, contact2, contact3));
	}
}
