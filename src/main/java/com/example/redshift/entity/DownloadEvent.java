package com.example.redshift.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DownloadEvent {

    private Integer id;

    private String eventHash;

    private Integer eventId;

    private String deviceId;

    private String sessionId;

    private String eventDate;

    private String processedDate;

    private String productId;

    private String assemblyVersion;

    private String status;

    private String duration;

    private String modelNumber;
}
