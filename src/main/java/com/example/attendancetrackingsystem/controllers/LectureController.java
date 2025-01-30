package com.example.attendancetrackingsystem.controllers;

import com.example.attendancetrackingsystem.dto.LectureDto;
import com.example.attendancetrackingsystem.helpers.FileHelper;
import com.example.attendancetrackingsystem.models.Lecture;
import com.example.attendancetrackingsystem.service.LectureService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final FileHelper fileHelper;

    public LectureController(LectureService lectureService, FileHelper fileHelper) {
        this.lectureService = lectureService;
        this.fileHelper = fileHelper;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("lectures", lectureService.getAllLectures());
        return "lectures/index";
    }

    @GetMapping("/new")
    public String newLecture(Model model) {
        model.addAttribute("lecture", new LectureDto());
        return "lectures/new";
    }

    @PostMapping("/new")
    public String newLecture(
            @Valid @ModelAttribute LectureDto lectureDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam("file") MultipartFile file
    ) {
        if (bindingResult.hasErrors()) {
            return "lectures/new";
        }

        try {
            if (!file.isEmpty()) {
                String fileName = fileHelper.uploadFile(
                        "target/classes/static/assets/files/lectures",
                        file.getOriginalFilename(),
                        file.getBytes()
                );
                lectureDto.setLectureUrl("/assets/files/lectures/" + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }

        lectureService.addLecture(lectureDto);
        redirectAttributes.addFlashAttribute("successMessage", "Lecture added successfully!");
        return "redirect:/lectures";
    }

    @GetMapping("/{id}/edit")
    public String editLecture(Model model, @PathVariable Long id) {
        model.addAttribute("lecture", lectureService.getLectureById(id));
        return "lectures/edit";
    }

    @PostMapping("/{id}/edit")
    public String editLecture(
            @Valid @ModelAttribute LectureDto lectureDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam("file") MultipartFile file,
            @PathVariable Long id
    ) {
        if (bindingResult.hasErrors()) {
            return "lectures/edit";
        }

        try {
            if (!file.isEmpty()) {
                String fileName = fileHelper.uploadFile(
                        "target/classes/static/assets/files/lectures",
                        file.getOriginalFilename(),
                        file.getBytes()
                );
                lectureDto.setLectureUrl("/assets/files/lectures/" + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }

        lectureService.updateLecture(id, lectureDto);
        redirectAttributes.addFlashAttribute("successMessage", "Lecture updated successfully!");
        return "redirect:/lectures";
    }
}