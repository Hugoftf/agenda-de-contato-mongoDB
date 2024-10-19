package com.hugo.agendadecontatos.ftf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hugo.agendadecontatos.ftf.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
