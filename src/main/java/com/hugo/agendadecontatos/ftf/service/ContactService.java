package com.hugo.agendadecontatos.ftf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.agendadecontatos.ftf.model.Contact;
import com.hugo.agendadecontatos.ftf.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	public Optional<Contact> findById(String id){
		return contactRepository.findById(id);
	}
	
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void deleteByID(String id) {
			contactRepository.deleteById(id);
	}
}
