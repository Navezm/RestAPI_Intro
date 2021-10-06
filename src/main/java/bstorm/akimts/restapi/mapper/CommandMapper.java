package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.CommandDTO;
import bstorm.akimts.restapi.models.entity.Command;
import bstorm.akimts.restapi.models.form.CommandForm;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CommandMapper implements BaseMapper<CommandDTO, CommandForm, Command>{
    private final CommandLineMapper commandLineMapper;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;

    public CommandMapper(CommandLineMapper commandLineMapper, AddressMapper addressMapper, UserMapper userMapper) {
        this.commandLineMapper = commandLineMapper;
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Command toEntity(CommandDTO dto) {
        if (dto == null)
            return null;

        return new Command(
                dto.getShippingDate(),
                dto.getPayType(),
                addressMapper.toEntity(dto.getShippingAddress()),
                dto.getCommandLines().stream()
                        .map(commandLineMapper::toEntity)
                        .collect(Collectors.toSet()),
                userMapper.toEntity(dto.getUser())
        );
    }

    @Override
    public CommandDTO toDto(Command entity) {
        if (entity == null)
            return null;

        CommandDTO commandDTO = new CommandDTO();

        commandDTO.setCommandLines(entity.getCommandLines()
                .stream()
                .map(commandLineMapper::toDto)
                .collect(Collectors.toSet()));
        commandDTO.setPayType(entity.getPayType());
        commandDTO.setShippingAddress(addressMapper.toDto(entity.getShippingAddress()));
        commandDTO.setUser(userMapper.toDto(entity.getUser()));
        commandDTO.setShippingDate(entity.getShippingDate());

        return commandDTO;
    }

    @Override
    public Command fromFormToEntity(CommandForm form) {
        if (form == null)
            return null;

        return new Command(
                form.getShippingDate(),
                form.getPayType(),
                form.getShippingAddress(),
                form.getCommandLines(),
                form.getUser()
        );
    }
}
