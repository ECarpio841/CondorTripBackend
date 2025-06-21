package com.example.condtrip.demo.controller

import com.example.condtrip.demo.entity.PlanItem
import com.example.condtrip.demo.services.PlanItemService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plan-items")
class PlanItemController(private val service: PlanItemService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody data: PlanItem) = service.save(data)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody data: PlanItem) =
        service.save(data.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = service.delete(id)
}