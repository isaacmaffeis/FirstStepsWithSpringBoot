package com.isaacmaffeis.firststepswithspringboot.app.mappers.impl;

import com.isaacmaffeis.firststepswithspringboot.app.domain.dto.AuthorDto;
import com.isaacmaffeis.firststepswithspringboot.app.domain.entities.AuthorEntity;
import com.isaacmaffeis.firststepswithspringboot.app.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Implementazione del Mapper per l'entità Author.
 * Questa classe fornisce i metodi per mappare un AuthorEntity in un AuthorDto e viceversa.
 */
@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Mappa un AuthorEntity in un AuthorDto.
     * @param authorEntity L'entità Author da mappare.
     * @return Un AuthorDto che rappresenta l'AuthorEntity fornito.
     */
    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    /**
     * Mappa un AuthorDto in un AuthorEntity.
     * @param authorDto Il DTO Author da mappare.
     * @return Un AuthorEntity che rappresenta l'AuthorDto fornito.
     */
    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
