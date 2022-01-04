//package br.com.codeflix.videos.domain.service.impl;
//
//import br.com.codeflix.videos.domain.service.old.UploadFileService;
//import com.google.api.gax.paging.Page;
//import com.google.auth.Credentials;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.auth.oauth2.ServiceAccountCredentials;
//import com.google.cloud.storage.*;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.WritableByteChannel;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//@Slf4j
//@Service("UploadGG")
//@Transactional
//@RequiredArgsConstructor
//public class UploadFileGGServiceImpl_BK implements UploadFileService {
//
////    private String bucketName = "codeflix-course";
//    private static String projectID = "code-flix-316723";
//    private static String pathConfigJson = "/var/home/alan/Developer/demo/gcloud/codeflix-couse-account-service.json";
//
//    private Storage storage;
//    private Bucket bucket;
//
//    @Override
//    public String uploadFile(Byte[] file) throws IOException {
////        Storage storage = StorageOptions.getDefaultInstance().getService();
//
////        Storage storage = StorageOptions.newBuilder()
////                .setCredentials(ServiceAccountCredentials
////                        .fromStream(new FileInputStream("")))
////                .build()
////                .getService();
//
//
//        // Use this variation to read the Google authorization JSON from the resources directory with a path
//        // and a project name.
//        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(pathConfigJson));
//        storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectID).build().getService();
//
//        // Bucket require globally unique names, so you'll probably need to change this
//        Bucket bucket = getBucket("codeflix-course");
//
//
//        // Save a simple string
//        BlobId blobId = saveString("my-first-blob", "Hi there!", bucket);
//
//        // Get it by blob id this time
//        String value = getString(blobId);
//
//        log.info("Read data: {}", value);
//
//        updateString(blobId, "Bye now!");
//
//        // Get the string by blob name
//        value = getString("my-first-blob");
//
//        log.info("Read modified data: {}", value);
//
//
//        // The name for the new bucket
////        String bucketName = "my-new-bucket";
//
////        Bucket bucket = storage.create(BucketInfo.of(bucketName));
//
//        log.info("Bucket %s created.%n", bucket.getName());
//        return null;
//    }
//
//    @Override
//    public String uploadFiles(List<Byte[]> files) {
//        return null;
//    }
//
//    @Override
//    public void deleteFile(String id) {
//
//    }
//
//    // Check for bucket existence and create if needed.
//    private Bucket getBucket(String bucketName) {
//        bucket = storage.get(bucketName);
//        if (bucket == null) {
//            System.out.println("Creating new bucket.");
//            bucket = storage.create(BucketInfo.of(bucketName));
//        }
//        return bucket;
//    }
//
//    // Save a string to a blob
//    private BlobId saveString(String blobName, String value, Bucket bucket) {
//        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
//        Blob blob = bucket.create(blobName, bytes);
//        return blob.getBlobId();
//    }
//
//    // get a blob by id
//    private String getString(BlobId blobId) {
//        Blob blob = storage.get(blobId);
//        return new String(blob.getContent());
//    }
//
//    // get a blob by name
//    private String getString(String name) {
//        Page<Blob> blobs = bucket.list();
//        for (Blob blob: blobs.getValues()) {
//            if (name.equals(blob.getName())) {
//                return new String(blob.getContent());
//            }
//        }
//        return "Blob not found";
//    }
//
//    // Update a blob
//    private void updateString(BlobId blobId, String newString) throws IOException {
//        Blob blob = storage.get(blobId);
//        if (blob != null) {
//            WritableByteChannel channel = blob.writer();
//            channel.write(ByteBuffer.wrap(newString.getBytes(StandardCharsets.UTF_8)));
//            channel.close();
//        }
//    }
//}
