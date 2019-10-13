package com.universe.service;

import java.util.List;

import com.universe.common.entity.domain.Resource;

public interface ResourceService {

  List<Resource> listResources();

  List<Resource> getResourcesByUsername(String username);

  Integer saveResource(Resource resource);

  Integer updateResource(Resource resource);

  Integer deleteResourceByResourceId(Integer resourceId);
}
