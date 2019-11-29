package amst.g1.amst_primeraevaluacion_g3_astudillo_sanchez.models;

public class Answer {
    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public Answer(Answer answer) {
        this.answer = answer.answer;
        this.correct = answer.correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", correct=" + correct +
                '}';
    }
}
