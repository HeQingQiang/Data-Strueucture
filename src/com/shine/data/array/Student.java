package com.shine.data.array;

/**
 * 学生类.
 *
 * @author shineYu
 * @date 2019/8/2 1:23
 * @Copyright shine_yu@vip.163.com .
 */
public class Student {

    private Integer score;
    private String name;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

}
