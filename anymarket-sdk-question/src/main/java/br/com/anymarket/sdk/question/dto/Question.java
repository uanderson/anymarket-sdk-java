package br.com.anymarket.sdk.question.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import br.com.anymarket.sdk.serializer.SDKDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements AnymarketPojo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("questionerName")
    private String questionerName;
    @JsonProperty("context")
    private String context;
    @JsonProperty("question")
    private String question;
    @JsonProperty("answers")
    private List<Answer> answers = new ArrayList<Answer>();
    @JsonProperty("questionDate")
    @JsonSerialize(using = SDKDateSerializer.class)
    private Date questionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionerName() {
        return questionerName;
    }

    public void setQuestionerName(String questionerName) {
        this.questionerName = questionerName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String getPathURI() {
        return "/questions";
    }

    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question1 = (Question) o;
        return Objects.equal(id, question1.id) &&
                Objects.equal(questionerName, question1.questionerName) &&
                Objects.equal(context, question1.context) &&
                Objects.equal(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, questionerName, context, question);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("questionerName", questionerName)
                .add("context", context)
                .add("question", question)
                .toString();
    }
}
