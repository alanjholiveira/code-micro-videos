package br.com.codeflix.videos.domain.service.old;

import br.com.codeflix.videos.infrastructure.enums.TypeUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UploadFileService {

    String uploadFile(MultipartFile file, String name, TypeUpload typeUpload) throws IOException;

    String uploadFiles(List<Byte[]> files);

    void deleteFile(String id);

}
