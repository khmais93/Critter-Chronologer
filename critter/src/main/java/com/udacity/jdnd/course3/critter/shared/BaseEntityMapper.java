package com.udacity.jdnd.course3.critter.shared;

public interface BaseEntityMapper<D,M> {

    D modelToDto(M model);
    M dtoToModel(D dto);
    
}
