package amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

    private String question;
    private List<Answer> answerList;


    public Question(String question, List<Answer> answerList) {
        this.question = question;
        this.answerList = answerList;
    }

    public Question(Question question) {
        this.question = question.question;
        this.answerList = new ArrayList<>();
        for (Answer a: question.answerList) {
            this.answerList.add(new Answer(a));
        }

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }
}
