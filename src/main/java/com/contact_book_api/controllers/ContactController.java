package com.contact_book_api.controllers;

import com.contact_book_api.persistence.entities.ContactEntity;
import com.contact_book_api.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<?> contactList() {
        List<ContactEntity> contactList = this.contactService.findAll();
        if (!contactList.isEmpty()) {
            return ResponseEntity.ok(this.contactService.findAll());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContactEntity> create(@Valid @RequestBody ContactEntity contact) {
        ContactEntity contactCreated = this.contactService.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactCreated);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ContactEntity contact = this.contactService.findById(id);
        return ResponseEntity.ok(contact);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<ContactEntity> contacts = this.contactService.findByNameContaining(name);
        if (!contacts.isEmpty()) return ResponseEntity.ok(contacts);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody ContactEntity updatedContact) {
        ContactEntity contactToUpdate = this.contactService.findById(updatedContact.getId());
        if (contactToUpdate != null) {
            ContactEntity contactUpdated = this.contactService.update(contactToUpdate, updatedContact);
            return ResponseEntity.ok(contactUpdated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ContactEntity contactToDelete = this.contactService.findById(id);
        if (contactToDelete != null) {
            this.contactService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    public ResponseEntity<?> partiallyUpdate(@RequestBody ContactEntity updatedContact) {
        ContactEntity contactToUpdate = this.contactService.findById(updatedContact.getId());
        if (contactToUpdate != null) {
            ContactEntity contactUpdated = this.contactService.partiallyUpdate(contactToUpdate, updatedContact);
            return ResponseEntity.ok(contactUpdated);
        }
        return ResponseEntity.notFound().build();
    }
}
