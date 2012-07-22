package egovframe.model;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

public class Board {

    String name;
    String description;
    Set<Post> posts = new TreeSet<Post>();
    
    
    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
    public String getName() { return name; }

    public String getDescription() { return description; }

    public Set<Post> getPosts() { return Collections.unmodifiableSet(posts); }

    
    public Post findPost(final Long postNo) {
        return Iterables.find(posts, new Predicate<Post>() {
            @Override
            public boolean apply(Post source) {
                return source.getNo().equals(postNo);
            }
        });
    }
    
    public Post writing(Post post) {
        if(Iterables.isEmpty(posts))
            posts.add(post.setNo(1l));
        else
            posts.add(post.setNo(Collections.max(posts).getNo() + 1));
        
        return post;
    }
    
    public Post editing(Post post) {
        Post origin = Iterables.find(posts, Predicates.equalTo(post), null);
        if(origin == null)
            throw new IllegalArgumentException("수정할 글(no:" + post.getNo() + ")이 없습니다.");
        
        BeanUtils.copyProperties(post, origin);
        
        return origin;
    }
    
    public Board erase(Post post) {
        if(!posts.contains(post))
            throw new IllegalArgumentException("삭제할 글(no:" + post.getNo() + ")이 없습니다.");
        
        posts.remove(post);
        
        return this;
    }
    
    public Board erase(Long postNo) {
        return erase(findPost(postNo));
    }
    
}
