package com.aerlingus.controller;

import io.swagger.annotations.ApiOperation;

public interface IActionController {

  @ApiOperation("Save traffic information to the database")
  void addTrafficInfo();

}
