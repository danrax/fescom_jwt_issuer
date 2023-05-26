package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.EducationDetailDto;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.EducationDetail;
import mx.escom.fescom.mappers.EducationDetailMapper;
import mx.escom.fescom.repositories.EducationDetailRepository;
import mx.escom.fescom.service.EducationDetailService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public record EducationDetailServiceImpl(
        EducationDetailRepository educationDetailRepository) implements EducationDetailService {

    @Override
    public void createEducationDetails(List<EducationDetailDto> educationDetailDtoList, Candidate candidate) {

        if (!ObjectUtils.isEmpty(educationDetailDtoList)) {
            List<EducationDetail> educationDetailList = new ArrayList<>();

            educationDetailDtoList.forEach(educationDetailDto -> {
                EducationDetail educationDetail = EducationDetailMapper.INSTANCE.toEntity(educationDetailDto);
                educationDetail.setCandidate(candidate);
                educationDetail.setUpdatedAt(LocalDateTime.now());
                educationDetailList.add(educationDetail);
            });

            educationDetailRepository.saveAllAndFlush(educationDetailList);
        }
    }

    @Override
    public void deleteEducationDetails(Long educationDetailId) {
        educationDetailRepository.delete(educationDetailRepository.getReferenceById(educationDetailId));
    }
}
