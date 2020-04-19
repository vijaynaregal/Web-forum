package jdbchm.servlet;

import java.util.Date;


public class jtopiclist {
Integer id;
String topic;
String author;
Integer replies;
Date date;
String content;

public jtopiclist(Integer id,String topic,String author,Date date, String content) {
	this.id = id;
	this.topic = topic;
	this.author =author;
	//this.replies = replies;
	this.date = date;
	this.content = content;
}

public jtopiclist(Integer replies) {
	this.replies=replies;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public Integer getReplies() {
	return replies;
}

public void setReplies(Integer replies) {
	this.replies = replies;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

}
