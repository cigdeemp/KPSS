package com.nexis.kpss_3;

public class TriviaQuestion {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String  answer_nr;
    private String category;

    // Parametresiz constructor
    TriviaQuestion(){

    };
    TriviaQuestion(String s, String string, String s1, String string1, String s2, String string2, String s3) {
    }

    public TriviaQuestion(String question, String option1, String option2, String option3, String option4, String option5, String answer_nr, String category) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.answer_nr = answer_nr;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getAnswer_nr() {
        return answer_nr;
    }

    public void setAnswer_nr(String answer_nr) {
        this.answer_nr = answer_nr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

