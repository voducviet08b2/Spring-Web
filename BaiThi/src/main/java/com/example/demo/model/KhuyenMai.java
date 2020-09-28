package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
    @Table(name="khuyenmai")
    public class KhuyenMai {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotEmpty
        private String title;
        @NotEmpty
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        private String timeStart;
        @NotEmpty
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        private String timeEnd;
        @Min(10000)
        private int saleOff;
        @NotEmpty
        private String detail;



    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(String timeStart) {
            this.timeStart = timeStart;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public int getSaleOff() {
            return saleOff;
        }

        public void setSaleOff(int saleOff) {
            this.saleOff = saleOff;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
