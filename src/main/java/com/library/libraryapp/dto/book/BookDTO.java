package com.library.libraryapp.dto.book;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ScienceBookDTO.class, name = "ScienceBook"),
        @JsonSubTypes.Type(value = LiteratureBookDTO.class, name = "LiteratureBook"),
        @JsonSubTypes.Type(value = HistoryBookDTO.class, name = "HistoryBook")
})
public abstract class BookDTO {


    private String title;
    private String author;
    private Integer publicationYear;
    private Integer totalCopies;
    private Integer availableCopies;
    private String isbn;
    //private Boolean available = true;

    public BookDTO() {}

    public BookDTO(String title, String author, int publicationYear, Integer totalCopies ,String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.isbn = isbn;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Integer getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public Integer getTotalCopies() { return totalCopies; }
    public void setTotalCopies(Integer totalCopies) { this.totalCopies = totalCopies; }

    public Integer getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(Integer availableCopies) { this.availableCopies = availableCopies; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

}
