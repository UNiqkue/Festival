package com.iba.festival.controller;

import com.iba.festival.domain.Festival;
import com.iba.festival.domain.User;
import com.iba.festival.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class FestivalController {
    @Autowired
    private FestivalRepository festivalRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Festival> festivals = festivalRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            festivals = festivalRepository.findByTag(filter);
        } else {
            festivals = festivalRepository.findAll();
        }

        model.addAttribute("festivals", festivals);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam String type,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Festival festival = new Festival(title, text, type, tag, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            festival.setFilename(resultFilename);
        }

        festivalRepository.save(festival);

        Iterable<Festival> festivals = festivalRepository.findAll();

//        model.put("countUsers", festival.getUsers().size());
//        model.put("countFestivals", user.getFests().size());
        model.put("festivals", festivals);
        model.put("userFestival", user);
        return "main";
    }

}
