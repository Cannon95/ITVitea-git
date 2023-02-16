package com.oefening.hallo2.service;

import com.oefening.hallo2.models.Kat;
import com.oefening.hallo2.repository.KatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KatService {
    @Autowired
    KatRepository katRepository;

    public Kat addKat(Kat kat) {
        return katRepository.save(kat);
    }

    public Kat getOneKat() {
        return katRepository.findById((long) 1).get();
    }

    public Iterable<Kat> getAllKatten() {
        return katRepository.findAll();
    }


    public Kat getaKat(long id) {
        return katRepository.findById(id).get();
    }
}
