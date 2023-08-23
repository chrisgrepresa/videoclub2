package com.blockbuster.videoclub.dto;
import lombok.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieCustomerDTO {
    private Integer movieId;
    private String director;
    private String genre;
    private Date releaseYear;
    private String title;
    private String customerFirstName;
    private String customerLastName;
    private Date returnDate;
    private Boolean isReturned;
}


