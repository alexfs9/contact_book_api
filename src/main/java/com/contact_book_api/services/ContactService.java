package com.contact_book_api.services;

import com.contact_book_api.persistence.entities.ContactEntity;
import com.contact_book_api.persistence.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<ContactEntity> findAll() {
        return this.contactRepository.findAll();
    }

    public ContactEntity findById(Long id) {
        return this.contactRepository.findById(id).orElse(null);
    }

    public List<ContactEntity> findByNameContaining(String name) {
        return this.contactRepository.findByNameContaining(name);
    }

    @Transactional
    public ContactEntity save(ContactEntity contact) {
        return this.contactRepository.save(contact);
    }

    @Transactional
    public ContactEntity update(ContactEntity contactToUpdate, ContactEntity updatedContact) {
        contactToUpdate.setName(updatedContact.getName());
        contactToUpdate.setEmail(updatedContact.getEmail());
        contactToUpdate.setPhoneNumber(updatedContact.getPhoneNumber());
        return this.contactRepository.save(contactToUpdate);
    }

    @Transactional
    public ContactEntity partiallyUpdate(ContactEntity contactToUpdate, ContactEntity updatedContact) {
        if (updatedContact.getName() != null) contactToUpdate.setName(updatedContact.getName());
        if (updatedContact.getEmail() != null) contactToUpdate.setEmail(updatedContact.getEmail());
        if (updatedContact.getPhoneNumber() != null) contactToUpdate.setPhoneNumber(updatedContact.getPhoneNumber());
        return this.contactRepository.save(contactToUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        this.contactRepository.deleteById(id);
    }
}
