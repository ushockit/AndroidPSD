package com.example.myapplication.models;

public class UploadFileInfo {
    private String filename;
    private String extension;
    private Long size;

    public UploadFileInfo() {
    }

    public UploadFileInfo(String filename, String extension, Long size) {
        this.filename = filename;
        this.extension = extension;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UploadFileInfo{" +
                "filename='" + filename + '\'' +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                '}';
    }
}
