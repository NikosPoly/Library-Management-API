package com.library.libraryapp.dto.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;

public class HistoryBookDTO extends BookDTO {

    private String historicalPeriod;
    private String regionFocus;

    public HistoryBookDTO() {}

    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    public HistoryBookDTO(String title, String author, int publicationYear, int totalCopies, String isbn,
                          String historicalPeriod, String regionFocus) {
        super(title, author, publicationYear, totalCopies, isbn);
        this.historicalPeriod = historicalPeriod;
        this.regionFocus = regionFocus;
    }

    public String getHistoricalPeriod() { return historicalPeriod; }
    public void setHistoricalPeriod(String historicalPeriod) { this.historicalPeriod = historicalPeriod; }

    public String getRegionFocus() { return regionFocus; }
    public void setRegionFocus(String regionFocus) { this.regionFocus = regionFocus; }
}