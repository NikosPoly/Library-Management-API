package com.library.libraryapp.model.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.TypeAlias;


@TypeAlias("ScienceBook")
public class ScienceBook extends Book {

    @NotBlank(message = "Field of study is required")
    private String fieldOfStudy; // e.g. Physics, Biology, Chemistry

    private boolean textbook = false; // true if it is a textbook

    @Min(value = 1, message = "Edition number must be at least 1")
    private int editionNumber;

    public ScienceBook() {
        super();
    }

    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    public ScienceBook(String title, String author, int publicationYear, int totalCopies, String isbn,
                       String fieldOfStudy, boolean textbook, int editionNumber) {
        super(title, author, publicationYear, totalCopies, isbn);
        this.fieldOfStudy = fieldOfStudy;
        this.textbook = textbook;
        this.editionNumber = editionNumber;
    }

    @JsonIgnore
    @Override
    public String getCategory() {
        return "Science";
    }

    // Getters and setters
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public boolean isTextbook() {
        return textbook;
    }

    public void setTextbook(boolean textbook) {
        this.textbook = textbook;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }
}