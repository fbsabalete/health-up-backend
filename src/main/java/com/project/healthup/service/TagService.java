package com.project.healthup.service;

import com.project.healthup.dto.MetaData;
import com.project.healthup.dto.PageResponse;
import com.project.healthup.dto.TagDto;
import com.project.healthup.mapper.TagMapper;
import com.project.healthup.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private static final TagMapper mapper = Mappers.getMapper(TagMapper.class);

    public PageResponse<TagDto> findTags(String name, Pageable pageable) {
        Page<TagDto> result;
        if(StringUtils.isNotBlank(name)) {
            result = tagRepository.findByNameStartsWithIgnoreCase(name, pageable)
                    .map(mapper::toDto);
        } else {
            result = tagRepository.findAll(pageable)
                    .map(mapper::toDto);
        }
        return PageResponse.of(
                result.getContent(),
                MetaData.of(result.getTotalElements(), result.getTotalPages(), result.hasNext())
        );
    }

}
