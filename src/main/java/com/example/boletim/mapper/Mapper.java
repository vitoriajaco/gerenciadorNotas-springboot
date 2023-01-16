package com.example.boletim.mapper;

public interface Mapper <F,T> {

    //Será responsavel por transformar um DTO em model e vice-versa.

    T convert (F f);
}
