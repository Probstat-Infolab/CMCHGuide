package com.probstatinfolab.cmchguide;

/**
 * Created by RONY on 24-10-16.
 */
public class Option {

        private String name;
        private int img;

        public Option(String name, int img) {
            this.name = name;
            this.img = img;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

}
