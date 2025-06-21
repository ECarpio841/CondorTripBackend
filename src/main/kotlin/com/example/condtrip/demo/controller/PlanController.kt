package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.Plan
import com.example.condtrip.demo.services.PlanService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/planes")
class PlanController(private val service: PlanService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody data: Plan) = service.save(data)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody data: Plan) =
        service.save(data.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}