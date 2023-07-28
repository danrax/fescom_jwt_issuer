package mx.escom.fescom.mappers;

import mx.escom.fescom.dtos.JobPostDto;
import mx.escom.fescom.entities.JobPost;
import org.mapstruct.factory.Mappers;

public interface JobPostMapper {

    JobPostMapper INSTANCE = Mappers.getMapper(JobPostMapper.class);

    JobPost toEntity(JobPostDto jobPostDto);

    JobPostDto toDto(JobPost jobPost);
}
