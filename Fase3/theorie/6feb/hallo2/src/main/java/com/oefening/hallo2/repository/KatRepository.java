package com.oefening.hallo2.repository;

import com.oefening.hallo2.models.Kat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KatRepository extends CrudRepository<Kat, Long> {

}
