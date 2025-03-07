package com.example.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.model.FileInfo;
import com.example.board.repository.FileInfoRepository;

@Controller
public class DownloadController {
    @Autowired
    FileInfoRepository fileInfoRepository;

    @GetMapping("/download")
    public ResponseEntity<Resource> download(
            @RequestParam("fileId") int fileId) throws Exception {
        Optional<FileInfo> opt = fileInfoRepository.findById(fileId);
        FileInfo fileInfo = opt.get();
        String saveName = fileInfo.getSaveName();
        File file = new File("c:/files/" + saveName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header("content-disposition",
                        "filename=" + URLEncoder.encode(file.getName(), "utf-8"))
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
