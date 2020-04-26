package com.prashant21tube.springframework.service;

import com.prashant21tube.springframework.domain.Notes;
import org.springframework.stereotype.Service;

@Service
public interface NotesService extends CrudService<Notes, Long> {
}
