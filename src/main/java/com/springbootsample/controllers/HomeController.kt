package com.springbootsample.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Mamba on 6/6/16.
 *
 * Home Controller
 */
@Controller
class HomeController {
  @RequestMapping(value = *arrayOf("", "/", "/index.html"))
  fun home(): String {
    return "home"
  }
}
