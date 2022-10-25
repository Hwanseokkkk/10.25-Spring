package blog;

import java.util.ArrayList;

public class Post {
	
	private int id;
	private String subject;
	private Author author;
	private ArrayList<Comment> comments; //collection
	private ArrayList<Tag> tags; //collection
	private int draft;

}
