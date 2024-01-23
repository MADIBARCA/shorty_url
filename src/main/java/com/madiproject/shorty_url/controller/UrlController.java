package com.madiproject.shorty_url.controller;

import com.madiproject.shorty_url.dto.ShortUrlRequest;
import com.madiproject.shorty_url.dto.ShortUrlResponse;
import com.madiproject.shorty_url.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/url")
public class UrlController {

    private final UrlShortenerService service;

    @PostMapping("/create")
    public ResponseEntity<ShortUrlResponse> create(
            @RequestBody ShortUrlRequest request) {
        ShortUrlResponse response = service.createShortUrl(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{key}")
    public ResponseEntity<RedirectView> redirect(@PathVariable String key) {
        RedirectView redirectView = service.getFullUrl(key);
        return ResponseEntity.ok(redirectView);
    }
}


