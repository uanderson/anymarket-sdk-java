package br.com.anymarket.sdk.question.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Answer {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("answer")
    private String answer;

    public Answer() { }

    public Answer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Answer answer1 = (Answer) o;
        return Objects.equal(id, answer1.id) &&
                Objects.equal(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, answer);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("answer", answer)
                .toString();
    }
}
