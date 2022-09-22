package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.MemberType;

@Mapper
public interface MemberTypeMapper {
	List<MemberType> selectAll() throws Exception;

}
