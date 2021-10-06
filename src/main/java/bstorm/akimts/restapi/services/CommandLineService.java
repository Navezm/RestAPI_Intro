package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.CommandLineDTO;
import bstorm.akimts.restapi.models.form.CommandForm;
import bstorm.akimts.restapi.models.form.CommandLineForm;

import java.util.List;

public interface CommandLineService {
    List<CommandLineDTO> findAll();

    CommandLineDTO getOne(Long id);

    CommandLineDTO delete(Long id);

    CommandLineDTO update(Long id, CommandLineForm commandLineForm);

    CommandLineDTO insert(CommandLineForm commandLineForm);

}
