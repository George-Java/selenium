package com.george.selenium.entity;

public class Weightlifting {
    public String determineCategory(String sex, int weight) {
        if ("male".equals(sex)) {
            return determineMaleCategory(weight);
        } else if ("female".equals(sex)) {
            return determineFemaleCategory(weight);
        }
        throw new IllegalArgumentException("性别参数无效");
    }

    private String determineMaleCategory(int weight) {
        if (weight <= 56) {
            return "男子56公斤级";
        } else if (weight <= 62) {
            return "男子62公斤级";
        } else if (weight <= 69) {
            return "男子69公斤级";
        } else if (weight <= 77) {
            return "男子77公斤级";
        } else if (weight <= 85) {
            return "男子85公斤级";
        } else if (weight <= 94) {
            return "男子94公斤级";
        } else if (weight <= 105) {
            return "男子105公斤级";
        } else {
            return "男子105公斤以上级";
        }
    }

    private String determineFemaleCategory(int weight) {
        if (weight <= 48) {
            return "女子48公斤级";
        } else if (weight <= 53) {
            return "女子53公斤级";
        } else if (weight <= 58) {
            return "女子58公斤级";
        } else if (weight <= 63) {
            return "女子63公斤级";
        } else if (weight <= 69) {
            return "女子69公斤级";
        } else if (weight <= 75) {
            return "女子75公斤级";
        } else {
            return "女子75公斤以上级";
        }
    }
}