package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.CommandLineDTO;
import bstorm.akimts.restapi.models.entity.CommandLine;
import bstorm.akimts.restapi.models.form.CommandLineForm;
import org.springframework.stereotype.Service;

@Service
public class CommandLineMapper implements BaseMapper<CommandLineDTO, CommandLineForm, CommandLine> {
    private final ProductMapper productMapper;

    public CommandLineMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CommandLine toEntity(CommandLineDTO dto) {
        if (dto == null)
            return null;

        return new CommandLine(
                dto.getCommandId(),
                dto.getProductId(),
                productMapper.toEntity(dto.getProduct()),
                dto.getQtt()
        );
    }

    @Override
    public CommandLineDTO toDto(CommandLine entity) {
        if (entity == null)
            return null;

        CommandLineDTO commandLineDTO = new CommandLineDTO();

        commandLineDTO.setCommandId(entity.getCommandId());
        commandLineDTO.setProduct(productMapper.toDto(entity.getProduct()));
        commandLineDTO.setProductId(entity.getProductId());
        commandLineDTO.setQtt(entity.getQtt());

        return commandLineDTO;
    }

    @Override
    public CommandLine fromFormToEntity(CommandLineForm form) {
        if (form == null)
            return null;

        return new CommandLine(
                form.getCommandId(),
                form.getProductId(),
                form.getProduct(),
                form.getQtt()
        );
    }
}
