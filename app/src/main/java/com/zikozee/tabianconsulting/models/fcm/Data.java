package com.zikozee.tabianconsulting.models.fcm;

public class Data {

    private String title;
    private String message;
    private String data_type;

    public Data(String title, String message, String data_type) {
        this.title = title;
        this.message = message;
        this.data_type = data_type;
    }

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", data_type='" + data_type + '\'' +
                '}';
    }

    private Data(Builder builder) {
        title = builder.title;
        message = builder.message;
        data_type = builder.data_type;
    }

    public static final class Builder {
        private String title;
        private String message;
        private String data_type;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder data_type(String val) {
            data_type = val;
            return this;
        }

        public Data build() {
            return new Data(this);
        }
    }
}
