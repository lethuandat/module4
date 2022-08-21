package vn.codegym.module4_exam.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NewsDto implements Validator {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    @Size(min = 1, max = 50, message = "*Tiêu đề không quá 50 kí tự")
    private String name;

    @NotBlank(message = "*Không được để trống!")
    @Size(min = 1, max = 500, message = "*Nội dung không quá 500 kí tự")
    private String content;

    @NotBlank(message = "*Không được để trống!")
    private String date;

    @NotBlank(message = "*Không được để trống!")
    private String interPreview;

    @NotBlank(message = "*Không được để trống!")
    private String category;

    public NewsDto() {
    }

    public NewsDto(Integer id, String name, String content, String date, String interPreview, String category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.interPreview = interPreview;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInterPreview() {
        return interPreview;
    }

    public void setInterPreview(String interPreview) {
        this.interPreview = interPreview;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void validate(Object target, Errors errors) {

        NewsDto newsDto = (NewsDto) target;

        if (Period.between(LocalDate.parse(newsDto.getDate(), formatter), LocalDate.now()).getDays() > 0) {
            errors.rejectValue("date", "date.fail", "*Ngày nhập lỗi");
        }
    }
}
