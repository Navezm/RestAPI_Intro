package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.CommandDTO;
import bstorm.akimts.restapi.models.form.CommandForm;

import java.util.List;

public interface CommandService {
    List<CommandDTO> findAll();

    CommandDTO getOne(Long id);

    CommandDTO delete(Long id);

    CommandDTO update(Long id, CommandForm commandForm);

    CommandDTO insert(CommandForm commandForm);
}
