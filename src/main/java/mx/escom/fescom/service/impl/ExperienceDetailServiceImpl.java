package mx.escom.fescom.service.impl;

import mx.escom.fescom.dtos.ExperienceDetailDto;
import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.ExperienceDetail;
import mx.escom.fescom.mappers.ExperienceDetailMapper;
import mx.escom.fescom.repositories.ExperienceDetailRepository;
import mx.escom.fescom.service.ExperienceDetailService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceDetailServiceImpl implements ExperienceDetailService {

    private final ExperienceDetailRepository experienceDetailRepository;

    public ExperienceDetailServiceImpl(ExperienceDetailRepository experienceDetailRepository) {
        this.experienceDetailRepository = experienceDetailRepository;
    }

    @Override
    public void createExperienceDetails(List<ExperienceDetailDto> experienceDetailDtoList, Candidate candidate) {


        if( !ObjectUtils.isEmpty(experienceDetailDtoList) ){
            List<ExperienceDetail> experienceDetailList = new ArrayList<>();
            experienceDetailDtoList.forEach( experienceDetailDto -> {
                ExperienceDetail experienceDetail = ExperienceDetailMapper.INSTANCE.toEntity(experienceDetailDto);
                experienceDetail.setCandidate(candidate);
                experienceDetail.setUpdatedAt(LocalDateTime.now());
                experienceDetailList.add(experienceDetail);
            });

            experienceDetailRepository.saveAllAndFlush(experienceDetailList);
        }
    }

    @Override
    public void deleteExperienceDetail(Long experienceDetailId) {
        experienceDetailRepository.delete(experienceDetailRepository.getReferenceById(experienceDetailId));
    }
}
