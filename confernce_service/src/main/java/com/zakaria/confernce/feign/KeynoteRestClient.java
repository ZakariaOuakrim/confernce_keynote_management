package com.zakaria.confernce.feign;

import com.zakaria.confernce.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/api/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable Long id);

    @GetMapping("/api/keynotes")
    PagedModel<Keynote> getAllkeynotes();
}
