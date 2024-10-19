package com.hugo.agendadecontatos.ftf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.agendadecontatos.ftf.exception.ObjectNotFoundException;
import com.hugo.agendadecontatos.ftf.model.Contact;
import com.hugo.agendadecontatos.ftf.service.ContactService;

@RestController
@RequestMapping("agenda/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public List<Contact> findAllContacts(){
		return contactService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> findContactById(@PathVariable String id){
		return contactService.findById(id).map(ResponseEntity::ok).orElseThrow(() -> new ObjectNotFoundException("Contato não encontrado"));
	}
	
	@PostMapping
	public ResponseEntity<Contact> creatContact(@RequestBody Contact contact){
		Contact createdContact = contactService.save(contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteContact(@PathVariable String id) {
		findContactById(id);
		contactService.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContacts(@PathVariable String id, @RequestBody Contact contact){
		Optional<Contact> existingContact = contactService.findById(id);
		if (existingContact == null) {
			throw new ObjectNotFoundException("Contato não encontrado");
		}
		
		contact.setId(id);
		Contact updateContact = contactService.save(contact);
		
		return ResponseEntity.ok(updateContact);
	}
}
