package com.mcss.msaccount.Util.Mapper.Abstracts;

import org.modelmapper.ModelMapper;

public interface MapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();

}
