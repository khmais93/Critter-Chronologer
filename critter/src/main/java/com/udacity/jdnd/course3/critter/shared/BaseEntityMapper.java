package com.udacity.jdnd.course3.critter.shared;

public interface BaseEntityMapper<D,M> {

    D ModeltoDto(M model);
    M DtoToModel(D dto);
    
}
