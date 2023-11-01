package com.project.healthup.service;

import com.project.healthup.dto.DietDTO;
import com.project.healthup.dto.DietDetailsDTO;
import com.project.healthup.dto.DietPostDTO;
import com.project.healthup.dto.MetaData;
import com.project.healthup.dto.PageResponse;
import com.project.healthup.exception.BaseException;
import com.project.healthup.mapper.DietMapper;
import com.project.healthup.model.Diet;
import com.project.healthup.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;
    private static final DietMapper mapper = Mappers.getMapper(DietMapper.class);

    public PageResponse<DietDTO> getDiets(Pageable pageable) {
        Page<DietDTO> result = dietRepository.findAll(pageable)
                .map(mapper::toDto);
        return PageResponse.of(
                result.getContent(),
                MetaData.of(result.getTotalElements(), result.getTotalPages(), result.hasNext())
        );
    }

    public DietDetailsDTO findById(Long id) {
        return dietRepository.findById(id)
                .map(mapper::toDetailDto)
                .orElseThrow(() -> new BaseException("Diet not found", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public void save(DietPostDTO dto) {
        dietRepository.save(mapper.toEntity(dto));
    }

    @Transactional
    public void update(Long id, DietPostDTO dto) {
        Diet existingDiet = dietRepository.findById(id)
                .orElseThrow(() -> new BaseException("Diet not found", HttpStatus.NOT_FOUND));
        dietRepository.save(mapper.update(existingDiet, dto));
    }

    @Transactional
    public void deleteById(Long id) {
        dietRepository.deleteById(id);
    }
}
