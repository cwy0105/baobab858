package com.baobab.m.dao;

@Mapper
public interface VersionMapper {
	int newVersion();
	String getStatus();
}
