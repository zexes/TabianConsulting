package com.zikozee.tabianconsulting.models.fcm;

public class FirebaseCloudMessage {

    private String to;
    private Data data;

    @Override
    public String toString() {
        return "FirebaseCloudMessage{" +
                "to='" + to + '\'' +
                ", data=" + data +
                '}';
    }

    private FirebaseCloudMessage(Builder builder) {
        to = builder.to;
        data = builder.data;
    }


    public static final class Builder {
        private String to;
        private Data data;

        public Builder() {
        }

        public Builder to(String val) {
            to = val;
            return this;
        }

        public Builder data(Data val) {
            data = val;
            return this;
        }

        public FirebaseCloudMessage build() {
            return new FirebaseCloudMessage(this);
        }
    }
}
