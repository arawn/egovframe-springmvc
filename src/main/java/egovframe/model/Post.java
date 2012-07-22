package egovframe.model;

public class Post implements Comparable<Post> {

    Long no = 0l;
    String title;
    String content;
    String writer;

    
    public Post() { }
    
    public Post(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    
    
    public Long getNo() { return no; }
    public Post setNo(Long no) { this.no = no; return this; };
    
    public String getTitle() { return title; }
    public Post setTitle(String title) { this.title = title; return this; };
    
    public String getContent() { return content; }
    public Post setContent(String content) { this.content = content; return this; };
    
    public String getWriter() { return writer; }
    public Post setWriter(String writer) { this.writer = writer; return this; };
 
    
    @Override
    public int compareTo(Post target) {
        return no.compareTo(target.no);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (no ^ (no >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (no != other.no)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Post [no=" + no + ", title=" + title + ", content=" + content
                + ", writer=" + writer + "]";
    }

}
