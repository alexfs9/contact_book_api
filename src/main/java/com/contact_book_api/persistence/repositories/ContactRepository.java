package com.contact_book_api.persistence.repositories;

import com.contact_book_api.persistence.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    List<ContactEntity> findByNameContaining(String name);

    Optional<ContactEntity> findByEmail(String email);

    Optional<ContactEntity> findByPhoneNumber(String phoneNumber);
}
