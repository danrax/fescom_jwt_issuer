package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.ContactDetailDto;
import mx.escom.fescom.entities.ContactDetail;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ContactDetailMapper {

    ContactDetailMapper INSTANCE = Mappers.getMapper(ContactDetailMapper.class);

    ContactDetailDto toDto(ContactDetail contactDetail);
}
